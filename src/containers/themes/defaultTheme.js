import blue from '@material-ui/core/colors/blue';
import cyan from '@material-ui/core/colors/cyan';

export default {
    palette: {
        primary: {
            light: blue[300],
            main: blue[500],
            dark: blue[700],
            contrastText: '#fff'
        },
        secondary: {
            light: cyan['A400'],
            main: cyan['A400'],
            dark: cyan['700'],
            contrastText: '#fff'
        }
    },
    status: {
        danger: 'orange',
    },
    typography: {
        button: {
            fontWeight: 400,
            textAlign: 'capitalize'
        },
    },
};
