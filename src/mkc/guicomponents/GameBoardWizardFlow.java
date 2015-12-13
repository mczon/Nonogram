package mkc.guicomponents;

import java.util.Optional;

import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.WizardPane;

public class GameBoardWizardFlow implements Wizard.Flow {

    private WizardPane mPage1;
    private WizardPane mPage2;
    private WizardPane mPage3;

    @Override
    public Optional<WizardPane> advance(WizardPane currentPage) {
        final WizardPane pane;
        if (currentPage == null) {
            mPage1 = new SetSizeDialog();
            pane = mPage1;
        } else if (currentPage == mPage1) {
            if (mPage2 == null) {
                mPage2 = new SetPatternDialog();
            }
            mPage2.setSize(mPage1.getSize());

        } else if (currentPage == mPage2) {
            if (mPage3 == null) {
                mPage3 = new SetFixedDialog();
            }
            mPage3.setSize(mPage1.getSize());
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
