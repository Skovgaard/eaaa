import React from "react";
import Header from "./components/footer/Footer"
import Footer from "./components/header/Header"

class App3 extends React.Component {
    render() {
        return (
            <div className="main">
                <Header />
                {/* <div className="header">Header</div> */}
                <div className="mid">
                    <h1>Hello World</h1>
                </div>
                <Footer />
                {/* <div className="footer">Footer</div> */}
            </div>
        )
    }
}

export default App3