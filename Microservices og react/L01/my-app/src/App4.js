import React from "react";
import Header from "./components/header/Header"
import Footer from "./components/footer/Footer"

class App4 extends React.Component {
    render() {
        return (
            <div className="main">
                <Header header="HEADER FOR FUNCTIONAL COMPONENT"/>
                {/* <Header /> */}
                {/* <div className="header">Header</div> */}
                <div className="mid">
                    <h1>Hello World</h1>
                </div>
                <Footer footer="FOOTER FOR CLASS COMPONENT"/>
                {/* <Footer /> */}
                {/* <div className="footer">Footer</div> */}
            </div>
        )
    }
}

export default App4