package application.controller;

import application.model.HistoryPaneModel;
import application.model.Spending;
import application.view.pane.HistoryPane;
import application.view.pane.HistoryPaneModal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author PC
 */
public class HistoryPaneController {

    private HistoryPane historyPane;
    private HistoryPaneModel historyPaneModel;
    private HistoryPaneModal modal;
    private List<Integer> ids;

    public HistoryPaneController() {
        this.historyPaneModel = new HistoryPaneModel();
    }

    public void setHistoryPane(HistoryPane historyPane) {
        this.historyPane = historyPane;
    }

    public void randerAll() {
        render(historyPaneModel.getALl());
    }

    public void randerByDate(Date date) {
        render(historyPaneModel.getByDate(date));
    }

    public void randerByMonth(Date month) {
        render(historyPaneModel.getByMonth(month));
    }

    private void render(List<Spending> spendings) {
        if (spendings == null) {
            return;
        }
        ids = new LinkedList<>();
        spendings.forEach(spending -> ids.add(spending.getId()));
        int total = spendings.stream().map(spending -> {
            return spending.getMoney();
        }).reduce(0, Integer::sum);
        historyPane.clearTable();
        historyPane.setTotal(total);
        historyPane.renderTable(spendings);
    }
    
    public void showModal(int type) {
        if (modal == null) {
            modal = new HistoryPaneModal();
            modal.setController(this);
            modal.setPurposeChooser(historyPaneModel.getPurposes());
        }
        modal.setSelectetDate(historyPane.getSelectedDate());
        modal.setTypeModal(type);
        if (type == HistoryPaneModal.EDIT) {
            int index = historyPane.getSelectedRow();
            int id = ids.get(index);
            modal.setEditMode(historyPaneModel.getById(id));

        }
        modal.show();

    }

    public void addNewSpening() {
        Spending spending = modal.createSpending();
        if (spending == null) {
            historyPane.showNotificationError("Nh???p d??? li???u kh??ng h???p l???");
            return;
        }
        modal.clearInput();
        if (historyPaneModel.addSpending(spending)) {
            historyPane.showNotificationSucsess("Th??m Th??nh c??ng !");
            historyPane.filterAction();

        } else {
            historyPane.showNotificationError("Th??m th???t b???i !!");
        }

    }

    public void removeSpending() {
        int index = historyPane.getSelectedRow();
        int id = ids.get(index);
        if (historyPaneModel.removeSpending(id)) {
            historyPane.showNotificationSucsess("Xo?? th??nh c??ng");
        } else {
            historyPane.showNotificationSucsess("X??a th???t b???i");
        }
        historyPane.filterAction();
    }

    public void saveEdit() {
        int index = historyPane.getSelectedRow();
        int id = ids.get(index);
        Spending spending = modal.createSpending();
        spending.setId(id);
        if (historyPaneModel.updateSpending(spending)) {
            historyPane.filterAction();
            historyPane.showNotificationSucsess("???? l??u ch???nh s???a");
            modal.clearInput();
            modal.hide();

        } else {
            historyPane.showNotificationError("Ch???nh s???a kh??ng ???????c l??u");
        }
    }

}
