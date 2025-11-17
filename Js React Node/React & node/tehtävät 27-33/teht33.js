/*33. Tee ao. kuvan mukainen React-sovellus (sovellukseen riittää tehdä vain layout siten, 
    että sovelluksessa on 5 komponenttia, yksi jokaiseen "laatikkoon"). 
    Komponentit ovat: <Header>, <Footer>, <LeftSide>, <Center> ja <RightSide>, 
    nimistä selviää mihin kukin komponentti sijoitetaan. Tee lisäksi komponentti <Teht33>, 
    joka sisältää siis em. komponentit. Värit ovat vain selventämässä kuvaa, niitä ei ole pakko noudattaa.
    */

import { Link, NavLink, Routes, Route, BrowserRouter as Router, useNavigate, useLocation, Navigate } from 'react-router-dom'
export const Teht33 = () => {
    return <div style={{ width: "90vw", margin: "auto", borderleft: "1px dashed", borderright:"1px dashed", padding: "20px", height:"100%" }} >

    <div style={{ border: "1px solid green",height:"100px", marginbottom:"20px"}}>
        <Header />
    </div>

        <div style={{ display: "flex", flexdirection: "row",border: "1px solid pink", }}>

            <div style={{ float:"left", width:"20%", padding: "20px", border: "1px solid red" }}>
                <LeftSide />
            </div>

            <div style={{ float: "left", width:"60%",padding: "20px", border: "1px solid yellow" }}>
                <Center />
            </div>

            <div style={{ float:"right", width:"20",padding: "20px", border: "1px solid black" }}>
                <RightSide />
            </div>
            
        </div>

    <div style={{ border: "1px solid green",height:"100px", marginbottom:"20px", border: "1px solid aqua", padding: "8px" }}>
        <Footer />
    </div>

</div>
}



//style={{flex-grow: "3"}}
//style={{flex-basis: "20%",flex-grow: "0",padding: "20px"}}


function Header(props) {
    return <div ><p>This is Header</p></div>
}
function LeftSide(props) {
    return <div><p>This is LeftSide</p></div>
}
function Center(props) {
    return <div><p>This is Center</p></div>
}
function RightSide(props) {
    return <div><p>This is RightSide</p></div>
}
function Footer(props) {
    return <div><p>This is Footer</p></div>
}
/*
      <div>
            <Header />
        </div>
        <LeftSide />
        <div>
            <Center />
        </div>
        <div>
            <RightSide />
        </div>
        <div>
            <Footer />
        </div>

<div style={{display: "grid",gridcolumn: "100px 100px 100px 100px",gridtemplaterows: "100px minmax(100px,auto) 100px",
        gap:  "5px", 
        gridtemplateareas:"'header header header header''sidebara main main sidebarb''footer footer footer footer'",  border: "1px solid blue", gap: "10px" }} >
        <div  className="header" style={{  border: "1px solid green", width: "100%", padding: "8px" }}>
            <Header />
        </div>

                <div className="sidebara" style={{  padding: "20px", border: "1px solid red" }}>
                    <LeftSide />
                </div>

                <div className="main" style={{ padding: "20px", border: "1px solid yellow" }}>
                    <Center />
                </div>

                <div className="sidebarb" style={{ padding: "20px", border: "1px solid black" }}>
                    <RightSide />
                </div>

        <div className="footer" style={{ width: "100%", border: "1px solid aqua", padding: "8px" }}>
            <Footer />
        </div>
    </div>

<div style={{ display: "flex", flexDirection: "column", border: "1px solid blue", gap: "10px", flexwrap: "wrap" }} >

        <div style={{ border: "1px solid green", width: "100%", padding: "8px" }}>
            <Header />
        </div>

            <div style={{ display: "",border: "1px solid pink", flexDirection: "row", flex: 1, flexBasis: "100%" }}>

                <div style={{ flex: 2, padding: "20px", border: "1px solid red" }}>
                    <LeftSide />
                </div>

                <div style={{ flex: 4, padding: "20px", border: "1px solid yellow" }}>
                    <Center />
                </div>

                <div style={{ flex: 2, padding: "20px", border: "1px solid black" }}>
                    <RightSide />
                </div>
                
            </div>

        <div style={{ width: "100%", border: "1px solid aqua", padding: "8px" }}>
            <Footer />
        </div>

    </div>
*/