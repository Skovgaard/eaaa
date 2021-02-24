import React from 'react'
import InputField from "../inputfield/InputField"

class Header extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            loggedin: false
        }
        this.handleOnClick = this.handleOnClick.bind(this)
    }

    handleOnClick(event) {
        this.setState((prevState) => { return { loggedin: !prevState.loggedin } })
    }



    render() {
        if (!this.state.loggedin) {
            return (
                <div className="header">
                    {this.props.header}
                    <div>
                        <button id="login" onClick={this.handleOnClick}>Log in</button>
                        <button id="signup">Sign up</button>
                    </div>
                    <InputField />
                </div>
                // <div className="footer">Footer</div>
            )
        } else {
            return (
                <div className="header">
                    {this.props.header}
                    <div>
                        <button id="login" onClick={this.handleOnClick}>Log out</button>
                    </div>
                </div>
                // <div className="footer">Footer</div>
            )
        }
    }
}

export default Header