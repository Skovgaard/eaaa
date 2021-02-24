import React from 'react'
import Error from "../error/Error"

class InputField extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            value: '',
            error: false
        }
        this.changeStateValue = this.changeStateValue.bind(this)
    }

    changeStateValue(event) {
        this.setState(() => {
            var value = event.target.value
            if (value.length >= 4)
                return { value, error: false }
            else {
                return { value, error: true }
            }
        })
    }

    render() {
        return (
            <div>
                <input type="text" onChange={this.changeStateValue}></input>
                <Error error={this.state.error} />
            </div>
        )
    }

}

export default InputField