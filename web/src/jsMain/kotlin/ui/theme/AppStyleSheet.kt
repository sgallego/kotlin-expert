package ui.theme

import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto

object AppStyleSheet: StyleSheet() {

    init {
        "*" style {
            fontFamily("Verdana", "sans-serif")
        }

        "body" style {
            margin(0.px)
        }
    }

    val fab by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        position(Position.Fixed)
        bottom(16.px)
        right(16.px)
        width(64.px)
        height(64.px)
        borderRadius(50.percent)
        backgroundColor(Color("#6200EE"))
        color(Color.white)
        fontSize(24.px)
        lineHeight(1.em)
        cursor("pointer")
        property("box-shadow", "0 5px 5px 0 rgba(0, 0, 0, 0.4)")
        self + hover style {
            backgroundColor(Color("#6200eecc"))
        }
    }

    val topBar by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        padding(16.px)
        backgroundColor(Color("#6200EE"))
        gap(16.px)
    }

    val topBarTitle by style {
        color(Color.white)
        margin(0.px)
        fontSize(25.px)
        fontWeight("normal")
        property("margin-right", auto)
    }

    val topBarIcon by style {
        color(Color.white)
        fontSize(24.px)
        cursor("pointer")
        borderRadius(50.percent)
        padding(12.px)
        self + hover style {
            backgroundColor(Color("#ffffff4d"))
        }
    }

    val filtersAction by style {
        cursor("pointer")
    }

    val filtersActionExpanded by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
        backgroundColor(Color.white)
        borderRadius(4.px)
        position(Position.Absolute)
        top(16.px)
        right(16.px)
        property("box-shadow", "0 0 4px rgba(0, 0, 0, 0.25)")
        property("z-index", 1)
    }

    val filtersActionExpandedItem by style {
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        padding(16.px)
        minWidth(150.px)
        cursor("pointer")
    }

    val notesList by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(16.px)
        width(100.percent)
        height(100.percent)
        alignItems(AlignItems.Center)
    }

    val noteCard by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(80.percent)
        maxWidth(600.px)
        marginTop(8.px)
        marginBottom(8.px)
        padding(16.px)
        border(1.px, LineStyle.Solid, Color.black)
        borderRadius(4.px)
        cursor("pointer")
    }
    val noteCardHeader by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        width(100.percent)
    }
    val noteCardTitle by style {
        flex(1)
        lineHeight(1.5.em)
        margin(0.px)
        fontSize(20.px)
        fontWeight("normal")
    }

    val detailInput by style {
        padding(16.px)
        border(1.px, LineStyle.Solid, Color("#ccc"))
        borderRadius(4.px)
    }


}