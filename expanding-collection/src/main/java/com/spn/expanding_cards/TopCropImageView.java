package com.spn.expanding_cards;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Image View with custom content crop logic.
 */
public class TopCropImageView extends android.support.v7.widget.AppCompatImageView {
    public TopCropImageView(Context context) {
        super(context);
        setScaleType(ScaleType.MATRIX);
    }

    public TopCropImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setScaleType(ScaleType.MATRIX);
    }

    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean changed = super.setFrame(l, t, r, b);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Matrix matrix = getImageMatrix();
            float scaleFactor = getWidth() / (float) drawable.getIntrinsicWidth();
            matrix.setScale(scaleFactor, scaleFactor, 0, 0);
            setImageMatrix(matrix);
        }
        return changed;
    }

}
