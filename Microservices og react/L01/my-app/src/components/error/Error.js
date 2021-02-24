import React from 'react'

class Error extends React.Component {

    // constructor(props) {
    //     super(props)
    // }

    render() {
        if (this.props.error) {
            return (
                <div>Input too short</div>
            )
        } else {
            return (
                <div></div>
            )
        }
    }
}

export default Error