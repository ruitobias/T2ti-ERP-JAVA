/*
 * The MIT License
 * 
 * Copyright: Copyright (C) 2014 T2Ti.COM
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 *
 * @author Claudio de Barros (T2Ti.com)
 * @version 2.0
 */
package com.t2tierp.controleestoque.servidor;

import com.t2tierp.padrao.java.Constantes;
import com.t2tierp.padrao.servidor.HibernateUtil;
import com.t2tierp.controleestoque.java.RequisicaoInternaCabecalhoVO;
import com.t2tierp.controleestoque.java.RequisicaoInternaDetalheVO;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;

public class RequisicaoInternaCabecalhoDetalheAction implements Action {

    public RequisicaoInternaCabecalhoDetalheAction() {
    }

    public String getRequestName() {
        return "requisicaoInternaCabecalhoDetalheAction";
    }

    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Object[] pars = (Object[]) inputPar;
        Integer acao = (Integer) pars[0];

        switch (acao) {
            case Constantes.LOAD: {
                return load(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.INSERT: {
                return insert(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.UPDATE: {
                return update(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.DELETE: {
                return delete(inputPar, userSessionPars, request, response, userSession, context);
            }
        }
        return null;
    }

    private Response load(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        String pk = (String) pars[1];

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(RequisicaoInternaCabecalhoVO.class);
            criteria.add(Restrictions.eq("id", Integer.valueOf(pk)));

            RequisicaoInternaCabecalhoVO requisicaoInternaCabecalho = (RequisicaoInternaCabecalhoVO) criteria.uniqueResult();

            return new VOResponse(requisicaoInternaCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    public Response insert(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            RequisicaoInternaCabecalhoVO requisicaoInternaCabecalho = (RequisicaoInternaCabecalhoVO) pars[1];
            List<RequisicaoInternaDetalheVO> listaItens = (Vector) pars[2];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            requisicaoInternaCabecalho.setSituacao("A");
            session.save(requisicaoInternaCabecalho);

            for (int i = 0; i < listaItens.size(); i++) {
                listaItens.get(i).setRequisicaoInternaCabecalho(requisicaoInternaCabecalho);
                session.save(listaItens.get(i));
            }

            session.getTransaction().commit();

            return new VOResponse(requisicaoInternaCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response update(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            RequisicaoInternaCabecalhoVO requisicaoInternaCabecalho = (RequisicaoInternaCabecalhoVO) pars[2];
            List<RequisicaoInternaDetalheVO> listaItens = (Vector) pars[3];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(requisicaoInternaCabecalho);

            String sqlExcluir = "delete from REQUISICAO_INTERNA_DETALHE where ID not in (0";
            for (int i = 0; i < listaItens.size(); i++) {
                listaItens.get(i).setRequisicaoInternaCabecalho(requisicaoInternaCabecalho);
                session.saveOrUpdate(listaItens.get(i));
                sqlExcluir += "," + listaItens.get(i).getId();
            }
            sqlExcluir += ") and ID_REQ_INTERNA_CABECALHO = :id";
            Query query = session.createSQLQuery(sqlExcluir);
            query.setInteger("id", requisicaoInternaCabecalho.getId());
            query.executeUpdate();

            if (requisicaoInternaCabecalho.getSituacao().equals("D")) {
                for (int i = 0; i < listaItens.size(); i++) {
                    ControleEstoqueAction.atualizaEstoque(session, listaItens.get(i).getProduto().getId(), listaItens.get(i).getQuantidade().negate());
                }
            }

            session.getTransaction().commit();

            return new VOResponse(requisicaoInternaCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response delete(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        return null;
    }
}
