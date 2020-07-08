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
package com.t2tierp.nfe.cliente;

import com.t2tierp.nfe.java.NfeCabecalhoVO;
import com.t2tierp.nfe.java.NfeTransporteVO;
import com.t2tierp.nfe.java.NfeTransporteVolumeLacreVO;
import com.t2tierp.nfe.java.NfeTransporteVolumeVO;
import java.util.ArrayList;
import java.util.Map;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.java.Consts;

public class NfeTransporteVolumeGridController extends GridController implements GridDataLocator {

    private NfeDetalhe nfeDetalhe;
    private NfeCabecalhoVO nfeCabecalho;

    public NfeTransporteVolumeGridController(NfeDetalhe nfeDetalhe) {
        this.nfeDetalhe = nfeDetalhe;
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        if (nfeCabecalho.getTransporte().getListaTransporteVolume() == null) {
            nfeCabecalho.setTransporte(new NfeTransporteVO());
        }
        if (nfeCabecalho.getTransporte().getListaTransporteVolume() == null) {
            nfeCabecalho.getTransporte().setListaTransporteVolume(new ArrayList<NfeTransporteVolumeVO>());
        }
        return new VOListResponse(nfeCabecalho.getTransporte().getListaTransporteVolume(), false, nfeCabecalho.getTransporte().getListaTransporteVolume().size());
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        if (nfeDetalhe.getFormDadosNfe().getMode() == Consts.READONLY) {
            nfeDetalhe.getFormDadosNfe().setMode(Consts.EDIT);
        }
        return true;
    }

    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        return new VOListResponse(newValueObjects, false, newValueObjects.size());
    }

    @Override
    public boolean beforeEditGrid(GridControl grid) {
        if (nfeDetalhe.getFormDadosNfe().getMode() == Consts.READONLY) {
            nfeDetalhe.getFormDadosNfe().setMode(Consts.EDIT);
        }
        return true;
    }

    @Override
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    @Override
    public boolean beforeDeleteGrid(GridControl grid) {
        if (nfeDetalhe.getFormDadosNfe().getMode() == Consts.READONLY) {
            nfeDetalhe.getFormDadosNfe().setMode(Consts.EDIT);
        }
        return true;
    }

    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    public void setNfeCabecalho(NfeCabecalhoVO nfeCabecalho) {
        this.nfeCabecalho = nfeCabecalho;
    }

    @Override
    public void rowChanged(int rowNumber) {
        NfeTransporteVolumeVO volume = (NfeTransporteVolumeVO) nfeDetalhe.getGridControlTransporteVolume().getVOListTableModel().getObjectForRow(rowNumber);
        if (volume != null) {
            if (volume.getListaTransporteVolumeLacre() == null) {
                volume.setListaTransporteVolumeLacre(new ArrayList<NfeTransporteVolumeLacreVO>());
            }
            nfeDetalhe.getTransporteVolumeLacreController().setTransporteVolumeLacre(volume.getListaTransporteVolumeLacre());
            nfeDetalhe.getGridControlTransporteVolumeLacre().reloadData();
        }
    }
}
