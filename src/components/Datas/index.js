import React, { Component } from 'react';
import PropTypes from 'prop-types';
import 'react-dates/initialize';
import 'react-dates/lib/css/_datepicker.css';
import { DateRangePicker } from 'react-dates';
import moment from 'moment';
import 'moment/locale/pt-br';


class Filtros extends Component {
	state = {
		startDate: moment(),
		endDate: moment(),
		focusedInput: null
	};
	handleChange = ({ startDate, endDate }) => {
		this.setState({ startDate, endDate });
		this.props.onChange({ startDate, endDate });
	};
	UNSAFE_componentWillMount() {
		const { startDate, endDate } = this.state;
		this.props.onChange({ startDate, endDate });
	}
	render() {
        const {startDate, endDate} = this.props;
		return (
			<div>
				<DateRangePicker
					startDatePlaceholderText="Data Inicial"
					endDatePlaceholderText="Data Final"
					startDate={startDate} // momentPropTypes.momentObj or null,
					startDateId="dashDataInicial" // PropTypes.string.isRequired,
					endDate={endDate} // momentPropTypes.momentObj or null,
					endDateId="dashDataFinal" // PropTypes.string.isRequired,
					onDatesChange={this.handleChange} // PropTypes.func.isRequired,
					focusedInput={this.state.focusedInput} // PropTypes.oneOf([START_DATE, END_DATE]) or null,
					onFocusChange={(focusedInput) => this.setState({ focusedInput })} // PropTypes.func.isRequired,
					hideKeyboardShortcutsPanel={true}
					isOutsideRange={() => false}
                    showClearDates={true}
                    noBorder={true}
					phrases={{
						calendarLabel: 'Calendário',
						closeDatePicker: 'Fechar',
						clearDates: 'Limpar Datas'
					}}
				/>
			</div>
		);
	}
}

Filtros.propTypes = {};

export default Filtros;
