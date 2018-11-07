import blue from '@material-ui/core/colors/blue';
import green from '@material-ui/core/colors/green';

export default {
    palette: {
        primary: {
            light: blue[300],
            main: blue[500],
            dark: blue[700],
            contrastText: '#fff'
        },
        secondary: {
            light: green['A100'],
            main: green['A700'],
            dark: green[700],
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
