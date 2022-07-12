package application.controller;

import application.view.MainFrame;
import application.view.components.navigation.EventNavigationBar;
import application.view.components.transitionpane.PanelTransitions;
import application.view.pane.HistoryPane;
import application.view.pane.StatictisPane;
import org.jdesktop.animation.timing.Animator;

/**
 *
 * @author PC
 */
public class Controller implements EventNavigationBar {

    private PanelTransitions panelTransitions;
    private Animator animator;

    public void setUpController(MainFrame mainFrame) {
        this.animator = mainFrame.getNavigationBar().getAnimator();
        this.panelTransitions = mainFrame.getPanelTransitions();
    }

    @Override
    public void beforeSelected(int index) {
        switch (index) {
            case 0 ->
                panelTransitions.display(new HistoryPane(new HistoryPaneController()), animator);
            case 1 ->
                panelTransitions.display(new StatictisPane(new StatictisController()), animator);
            default -> {
            }
        }

    }

    @Override
    public void afterSelected(int index) {

    }

}
