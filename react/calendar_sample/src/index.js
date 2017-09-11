import React from 'react'
import ReactDOM from 'react-dom'
import 'rc-calendar/assets/index.css'
import Calendar from 'rc-calendar'
import DatePicker from 'rc-calendar/lib/Picker'
import 'rc-time-picker/assets/index.css'
import TimePickerPanel from 'rc-time-picker/lib/Panel'
import moment from 'moment'

const format = 'YYYY-MM-DD HH:mm'
const now = moment()
const timePickerElement = <TimePickerPanel defaultValue={moment('00:00', 'HH:mm')}/>

function disabledDate(current) {
  if (!current) {
    // allow empty select
    return false
  }
  const date = moment()
  date.hour(0)
  date.minute(0)
  // can not select days before today
  return current.valueOf() < date.valueOf()
}

class DatePickerInput extends React.Component {

  static propTypes = {
    defaultValue: React.PropTypes.object,
    defaultCalendarValue: React.PropTypes.object,
  }

  constructor(props) {
    super(props);

    this.state = {
      value: this.props.defaultValue,
    }
  }

  onChange(value) {
    console.log('DatePicker change: ', (value && value.format(format)))
    this.setState({
      value: value
    })
  }

  render() {
    const state = this.state
    const calendar = (<Calendar
      style={{zIndex: 1000}}
      dateInputPlaceholder="入力してください"
      formatter={format}
      timePicker={timePickerElement}
      defaultValue={this.props.defaultCalendarValue}
      disabledDate={disabledDate}
    />)
    return (
      <div>
        <DatePicker
          animation="slide-up"
          calendar={calendar}
          value={state.value}
          onChange={this.onChange.bind(this)}
        >
          {
            ({value}) => {
              return (
                <span tabIndex="0">
                <input
                  placeholder="入力してください"
                  readOnly
                  tabIndex="-1"
                  className="ant-calendar-picker-input ant-input"
                  value={value && value.format(format) || ''}
                />
                </span>
              )
            }
          }
        </DatePicker>
      </div>
    )
  }
}

ReactDOM.render((
  <div>
    <DatePickerInput defaultValue={now}/>
  </div>), document.getElementById('root'))
