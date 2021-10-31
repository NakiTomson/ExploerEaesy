package com.testtask.core_ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.testtask.core_ui.R
import kotlin.math.max
import kotlin.math.roundToInt

class PagerLinearView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, style: Int) : super(context, attrs, style) {
        initView(context, attrs)
    }

    /**
     * Количество линий
     * Из них одна будет указательная линия и остальные будут пунктирные линии
     */
    private var linesCount = 4

    /**
     * Количество пунктирных линии(равно количеству страниц -1)
     */
    private var dropLinesCount = linesCount - 1

    /**
     * Выбранная линия
     */
    private var selectedLineNumber = 0

    /**
     * Цвет пункирной линии
     */
    @ColorInt
    private var dropLineColor = Color.LTGRAY

    /**
     * Ширина пунктирной линии
     */
    private var dropLineWidth: Float = 60f

    /**
     * Высота пунктирной линии
     */
    private var dropLineHeight: Float = 14f

    /**
     * Цвет указательной линии
     */
    @ColorInt
    private var indicatorLineColor = Color.RED

    /**
     * Ширина указательной линии
     */
    private var indicatorLineWidth: Float = 270f

    /**
     * Высота указательной линии
     */
    private var indicatorLineHeight: Float = 14f

    /**
     * Радиус X овала, используемого для закругления углов линии
     */
    private var lineCornerX: Float = 40f

    /**
     * Радиус Y овала, используемого для закругления углов линии
     */
    private var lineCornerY: Float = 40f

    /**
     * Размер промежутка между линиями
     */
    private var space: Float = 12f

    private fun initView(context: Context, attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.PagerLinearView,
            0, 0
        )
        dropLineWidth = typedArray.getDimension(R.styleable.PagerLinearView_plv_drop_line_width, dropLineWidth)
        dropLineHeight = typedArray.getDimension(R.styleable.PagerLinearView_plv_drop_line_height, dropLineHeight)
        dropLineColor = typedArray.getColor(R.styleable.PagerLinearView_plv_drop_line_color, dropLineColor)
        indicatorLineWidth = typedArray.getDimension(R.styleable.PagerLinearView_plv_indicator_line_width, indicatorLineWidth)
        indicatorLineHeight = typedArray.getDimension(R.styleable.PagerLinearView_plv_indicator_line_height, indicatorLineHeight)
        indicatorLineColor = typedArray.getColor(R.styleable.PagerLinearView_plv_indicator_line_color, indicatorLineColor)
        space = typedArray.getDimension(R.styleable.PagerLinearView_plv_line_space, space)
        linesCount = typedArray.getInt(R.styleable.PagerLinearView_plv_lines_count, linesCount)
        dropLinesCount = linesCount - 1
        typedArray.recycle()
    }

    /**
     * Установка кличества отображаемых линий
     *
     * @param count число линий
     */
    fun setLinesCount(count: Int) {
        linesCount = count
        requestLayout()
    }

    /**
     * Указать выбронную линию(указательная линия будет показана соответственно индексу выбранной линии)
     * @param lineNumber индекс выбранной линии
     */
    fun selectLine(lineNumber: Int) {
        selectedLineNumber = lineNumber
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var offsetX = 0f
        for (i in 0 until linesCount) {
            if (i == selectedLineNumber) {
                drawIndicatorLine(canvas, offsetX)
                offsetX += indicatorLineWidth + space
            } else {
                drawDropLine(canvas, offsetX)
                offsetX += dropLineWidth + space
            }
        }
    }

    private fun drawIndicatorLine(canvas: Canvas, offsetX: Float) {
        val rect = RectF(offsetX, 0f, offsetX + indicatorLineWidth, indicatorLineHeight)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = indicatorLineColor
        }
        canvas.drawRoundRect(rect, lineCornerX, lineCornerY, paint)
    }

    private fun drawDropLine(canvas: Canvas, offsetX: Float) {
        val rect = RectF(offsetX, 0f, offsetX + dropLineWidth, dropLineHeight)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = dropLineColor
        }
        canvas.drawRoundRect(rect, lineCornerX, lineCornerY, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val linesWidth = indicatorLineWidth + dropLinesCount * dropLineWidth
        val linesSpace = (linesCount - 1) * space
        var minWidth = (linesWidth + linesSpace).roundToInt() + paddingLeft + paddingRight + suggestedMinimumWidth
        if (minWidth < 0) {
            minWidth = 0
        }
        val newWidth = resolveSizeAndState(minWidth, widthMeasureSpec, 0)
        val newHeight = resolveSizeAndState((max(indicatorLineHeight, dropLineHeight)).toInt() + 1, heightMeasureSpec, 0)
        setMeasuredDimension(newWidth, newHeight)
    }
}