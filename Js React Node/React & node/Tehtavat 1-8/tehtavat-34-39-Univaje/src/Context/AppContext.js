import React, { useState, useContext } from 'react';

const DataContext = React.createContext({});

function AppContext() {

    //const data = { name: "Kalle", age: 45, id: 44, occupation: "lecturer", setData: () => { }, };

    const setData = (value) => {
        console.log("in setData: ", value);
        setStoredData({ ...storedData, name: value.name });
        // name : "Kalle", age : 45, name: "Liisa"
        //setStoredData(name );
    }
    const [students, setStudents] = useState([]);

    const initState = {
        name: "Kalle", age: 45, id: 44, occupation: "lecturer", setData: setData, students : students
        //students:[], courses : [], manageStudent: setData, manageCourses : setCourses
    }

    const [storedData, setStoredData] = useState(initState);

    return (
        <DataContext.Provider value={storedData}>
            <div>
                <p>This is ContextAPI App</p>
                <InfoComponent />
                <TestComponent />
            </div>
        </DataContext.Provider>
    )
}

function TestComponent() {
    // useContext:ia voi käyttää DataContext.Consumer:n sijaan!
    const dl = useContext(DataContext);
    const [name, setName] = useState(dl.name);

    const nameChanged = (value) => {
        setName(value);
        console.log("dl ", dl);
        dl.setData({ name: value });
    }

    return (
            <div>
                <p>TestComponent {name}</p>
                <form>
                    <label htmlFor="name">Enter your name</label>
                    <input type="text" name="name" onChange={(event) => nameChanged(event.target.value)} />
                </form>
                <ImageComponent />
            </div>
    );
}

function ImageComponent() {
    return (
        <DataContext.Consumer>
            {s => (
                <div>
                    <p>Notice props: function component</p>
                    <p>This is Image and value is {s.name} and {s.occupation}</p>
                    <p>NOTE! You retrieve the value like this! </p>
                </div>
            )
            }
        </DataContext.Consumer>
    );
}

class InfoComponent extends React.Component {
    // Vrt. useContext -> luokkapohjaisella komponentilla päästään context:iin käsiksi MYÖS tällä tavalla
    // Toinen tapa on käyttää samaa Consumer:ia kuin funktiopohjaisessa komponentissa
    // HUOM! Muuttuja on static ja sen nimi pitää olla contextType
    static contextType = DataContext;

    componentDidMount() {
        const data = this.context;
        console.log("data = ", data);
    }

    render() {
        const d = this.context.age;
/*
        return (
            <DataContext.Consumer>
                {value =>
                    <div>
                        <p>Information about user WITH consumer: {value.occupation} and {value.name} </p>
                        <p>Can we use context : {d}</p>
                    </div>
                }
            </DataContext.Consumer>            
        );
*/        
        return (
            <div>
                <p>Information about user WITHOUT Consumer: {this.context.occupation} and {this.context.name} </p>
                <p>Can we use context : {d}</p>
            </div>
        );
    }
}

export default AppContext;
