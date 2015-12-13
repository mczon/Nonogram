package main.java.mkc.guicomponents;

import java.util.Optional;

import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.WizardPane;

public class GameBoardWizardFlow implements Wizard.Flow {

    private final SetSizePane mPage1 = new SetSizePane();
    private final SetPatternPane mPage2 = new SetPatternPane();
    private final SetFixedPane mPage3 = new SetFixedPane();

    @Override
    public Optional<WizardPane> advance(WizardPane currentPage) {
        final WizardPane pane;
        if (currentPage == null) {
            pane = mPage1;
        } else if (currentPage instanceof SetSizePane) {
            mPage2.setSizeSettings(mPage1.getSizeSettings());
            pane = mPage2;
        } else if (currentPage instanceof SetPatternPane) {
            mPage3.setSizeSettings(mPage1.getSizeSettings());
            pane = mPage3;
        } else {
            // Shouldnt happen
            pane = null;
        }

        return Optional.of(pane);
    }

    @Override
    public boolean canAdvance(WizardPane currentPage) {
        return !(currentPage instanceof SetFixedPane);
    }
}
