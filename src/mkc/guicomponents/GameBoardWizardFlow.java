package mkc.guicomponents;

import java.util.Optional;

import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.WizardPane;

public class GameBoardWizardFlow implements Wizard.Flow {

    private WizardPane mPage1 = new SetSizePane();
    private WizardPane mPage2 = new SetPatternPane();
    private WizardPane mPage3 = new SetFixedPane();

    @Override
    public Optional<WizardPane> advance(WizardPane currentPage) {
        final WizardPane pane;
        if (currentPage == null) {
            pane = mPage1;
        } else if (currentPage == mPage1) {
            mPage2.setSize(mPage1.getSizeSettings());

        } else if (currentPage == mPage2) {
            mPage3.setSize(mPage1.getSizeSettings());
        }
    }

    @Override
    public boolean canAdvance(WizardPane currentPage) {
        final boolean canAdvance;
        if (currentPage == mPage3) {
            canAdvance = false;
        } else {
            canAdvance = true;
        }
        return canAdvance;
    }
}
