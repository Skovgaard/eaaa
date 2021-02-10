import React from "react";
import Header from "./components/header/Header"
import Footer from "./components/footer/Footer"

class App3 extends React.Component {
    render() {
        return (
            <div className="main">
                <Header />
                {/* <div className="header">Header</div> */}
                <div className="mid">
                    <h1>Hello World</h1>
                </div>
                {/* <div className="footer">Footer</div> */}
                <Footer />
            </div>
        )
    }
}

export default App3