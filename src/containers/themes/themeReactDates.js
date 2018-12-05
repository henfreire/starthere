import ThemedStyleSheet from 'react-with-styles/lib/ThemedStyleSheet';
import aphroditeInterface from 'react-with-styles-interface-aphrodite';
import DefaultTheme from 'react-dates/lib/theme/DefaultTheme';
const primary = '#fc7242';
const secondary = '#fc7242';
const white = '#FFF';
import Color from 'color';
import grey from '@material-ui/core/colors/grey';
ThemedStyleSheet.registerInterface(aphroditeInterface);
var core = {
	white: '#fff',
	gray: '#484848',
	grayLight: '#82888a',
	grayLighter: '#cacccd',
	grayLightest: '#f2f2f2',
	borderMedium: '#c4c4c4',
	border: '#dbdbdb',
	borderLight: '#e4e7e7',
	borderLighter: '#eceeee',
	borderBright: '#f4f5f5',
	primary: primary,
	primaryShade_1: Color(primary).lighten(0.5).hex(),
	primaryShade_2: Color(primary).lighten(0.1).hex(),
	primaryShade_3: Color(primary).lighten(0.2).hex(),
	primaryShade_4: Color(primary).lighten(0.25).hex(),
	primary_dark: Color(secondary).darken(0.25).hex(),
	secondary: secondary,
	yellow: secondary,
	yellow_dark: secondary
};

ThemedStyleSheet.registerTheme({
	reactDates: {
		zIndex: 0,
		border: {
			input: {
				border: 0,
				borderTop: 0,
				borderRight: 0,
				borderBottom: '2px solid transparent',
				borderLeft: 0,
				outlineFocused: 0,
				borderFocused: 0,
				borderTopFocused: 0,
				borderLeftFocused: 0,
				borderBottomFocused: '2px solid '.concat(core.primary_dark),
				borderRightFocused: 0,
				borderRadius: 0
			},
			pickerInput: {
				borderWidth: 1,
				borderStyle: 'solid',
				borderRadius: 2
			}
		},
		color: {
			core: core,
			disabled: core.grayLightest,
			background: core.white,
			backgroundDark: '#f2f2f2',
			backgroundFocused: core.white,
			border: 'rgb(219, 219, 219)',
			text: core.gray,
			textDisabled: core.border,
			textFocused: '#007a87',
			placeholderText: '#757575',
			outside: {
				backgroundColor: core.white,
				backgroundColor_active: core.white,
				backgroundColor_hover: core.white,
				color: core.gray,
				color_active: core.gray,
				color_hover: core.gray
			},
			highlighted: {
				backgroundColor: core.yellow,
				backgroundColor_active: core.yellow_dark,
				backgroundColor_hover: core.yellow_dark,
				color: core.gray,
				color_active: core.gray,
				color_hover: core.gray
			},
			minimumNights: {
				backgroundColor: core.white,
				backgroundColor_active: core.white,
				backgroundColor_hover: core.white,
				borderColor: core.borderLighter,
				color: core.grayLighter,
				color_active: core.grayLighter,
				color_hover: core.grayLighter
			},
			hoveredSpan: {
				backgroundColor: core.primaryShade_4,
				backgroundColor_active: core.primaryShade_3,
				backgroundColor_hover: core.primaryShade_4,
				borderColor: core.primaryShade_3,
				borderColor_active: core.primaryShade_3,
				borderColor_hover: core.primaryShade_3,
				color: core.secondary,
				color_active: core.secondary,
				color_hover: core.secondary
			},
			selectedSpan: {
				backgroundColor: core.primaryShade_2,
				backgroundColor_active: core.primaryShade_1,
				backgroundColor_hover: core.primaryShade_1,
				borderColor: core.primaryShade_1,
				borderColor_active: core.primary,
				borderColor_hover: core.primary,
				color: core.white,
				color_active: core.white,
				color_hover: core.white
			},
			selected: {
				backgroundColor: core.primary,
				backgroundColor_active: core.primary,
				backgroundColor_hover: core.primary,
				borderColor: core.primary,
				borderColor_active: core.primary,
				borderColor_hover: core.primary,
				color: core.white,
				color_active: core.white,
				color_hover: core.white
			},
			blocked_calendar: {
				backgroundColor: core.grayLighter,
				backgroundColor_active: core.grayLighter,
				backgroundColor_hover: core.grayLighter,
				borderColor: core.grayLighter,
				borderColor_active: core.grayLighter,
				borderColor_hover: core.grayLighter,
				color: core.grayLight,
				color_active: core.grayLight,
				color_hover: core.grayLight
			},
			blocked_out_of_range: {
				backgroundColor: core.white,
				backgroundColor_active: core.white,
				backgroundColor_hover: core.white,
				borderColor: core.borderLight,
				borderColor_active: core.borderLight,
				borderColor_hover: core.borderLight,
				color: core.grayLighter,
				color_active: core.grayLighter,
				color_hover: core.grayLighter
			}
		},
		spacing: {
			dayPickerHorizontalPadding: 9,
			captionPaddingTop: 22,
			captionPaddingBottom: 37,
			inputPadding: 0,
			displayTextPaddingVertical: undefined,
			displayTextPaddingTop: 11,
			displayTextPaddingBottom: 9,
			displayTextPaddingHorizontal: undefined,
			displayTextPaddingLeft: 11,
			displayTextPaddingRight: 11,
			displayTextPaddingVertical_small: undefined,
			displayTextPaddingTop_small: 7,
			displayTextPaddingBottom_small: 5,
			displayTextPaddingHorizontal_small: undefined,
			displayTextPaddingLeft_small: 7,
			displayTextPaddingRight_small: 7
		},
		sizing: {
			inputWidth: 130,
			inputWidth_small: 97,
			arrowWidth: 24
		},
		noScrollBarOnVerticalScrollable: false,
		font: {
			size: 14,
			captionSize: 18,
			input: {
                size: 16,
                fontWeight: 350,
				lineHeight: '24px',
				size_small: 15,
				lineHeight_small: '18px',
				letterSpacing_small: '0.2px',
				styleDisabled: 'italic'
			}
		}
	}
});
