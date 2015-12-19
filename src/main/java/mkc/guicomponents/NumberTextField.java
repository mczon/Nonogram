package main.java.mkc.guicomponents;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

    private boolean mAllowNegative = true;
    private final String mPositive = "[0-9]*";
    private final String mNegative = "-?[0-9]*";

    public NumberTextField(String startValue, boolean allowNegative) {
        this(startValue);
        mAllowNegative = allowNegative;
    }

    public NumberTextField(String startValue) {
        super();
        if (!"".equals(startValue) && validate(startValue)) {
            setText(startValue);
        }
    }

    public NumberTextField(int startValue, boolean allowNegative) {
        this(startValue);
        mAllowNegative = allowNegative;
    }
    public NumberTextField(int startValue) {
        super();
        setValue(startValue);
    }

    public void setValue(int value) {
        super.setText(Integer.toString(value));
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (validate(text)) {
            super.replaceSelection(text);
        }
    }

    public int getValue() {
        int retValue = 0;
        if (!"".equals(getText())) {
            retValue = Integer.parseInt(getText());
        }
        return retValue;
    }

    private boolean validate(String text) {
        final String nextValue = getText() + text;
        return ("".equals(nextValue) ||
                nextValue.matches(mAllowNegative ? mNegative : mPositive));
    }
}

