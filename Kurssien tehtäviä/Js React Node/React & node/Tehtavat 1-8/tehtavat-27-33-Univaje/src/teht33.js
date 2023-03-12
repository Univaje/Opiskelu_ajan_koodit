/*33. Tee ao. kuvan mukainen React-sovellus (sovellukseen riittää tehdä vain layout siten, 
    että sovelluksessa on 5 komponenttia, yksi jokaiseen "laatikkoon"). 
    Komponentit ovat: <Header>, <Footer>, <LeftSide>, <Center> ja <RightSide>, 
    nimistä selviää mihin kukin komponentti sijoitetaan. Tee lisäksi komponentti <Teht33>, 
    joka sisältää siis em. komponentit. Värit ovat vain selventämässä kuvaa, niitä ei ole pakko noudattaa.
    */

//import { Link, NavLink, Routes, Route, BrowserRouter as Router, useNavigate, useLocation, Navigate } from 'react-router-dom'
export const Teht33 = () => {
    return <div style={{ width: "90vw", margin: "auto", borderleft: "1px dashed", borderright:"1px dashed", padding: "20px", height:"100%" }} >

    <header style={{ border: "1px solid green",height:"100px", marginbottom:"20px"}}>
        <Header />
    </header>

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

export function Header(props) {
    return <p>Welcome to main page of Savonia AMK</p>
}
export function LeftSide(props) {
    return <div><p>Please log in</p></div>
}
export function Center(props) {
    return <div><p>Introduction of our company</p></div>
}
export function RightSide(props) {
    return <div><p>Lot's of info about our company</p></div>
}
export function Footer(props) {
    return <div><p>Copyright by ktkoiju@Savonia</p></div>
}
