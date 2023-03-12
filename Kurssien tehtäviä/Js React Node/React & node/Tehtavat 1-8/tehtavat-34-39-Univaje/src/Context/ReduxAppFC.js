import React, {useState} from 'react';
import { createStore } from "redux";
import { useDispatch, useSelector } from "react-redux";

// Install redux and react-redux packages first
// npm install redux
// npm install react-redux

export const ReduxAppFC = () =>
{
    return(
        <div>
            <p>This part is for React Redux (functional component)</p>
            <ArticleForm />
            <ArticleList />
            <StudentList />
        </div>
    );
}

// ACTION TYPE
const ADD_ARTICLE = "ADD_ARTICLE";
const DELETE_ARTICLE = "DELETE_ARTICLE";
const ADD_STUDENT = "ADD_STUDENT";

// REDUCER
const initialState = {
    articles: [],
    students: []
  };
  
// NOTE! Immutable state! 
// The resulting state is a copy of the current state added with the new data.
function rootReducer(state = initialState, action) {
    if (action.type === ADD_ARTICLE) {
        // Create a copy (clone) of current state -> Object.assign
        // Then combine old array with new article
        return Object.assign({}, state, {articles: state.articles.concat(action.payload)} );
    }
    else if (action.type === DELETE_ARTICLE)
    {
        return Object.assign({}, state, {articles: state.articles.filter(a => a.id !== action.payload.id)} );
    }
    else if (action.type === ADD_STUDENT) {
        return Object.assign({}, state, {students: state.students.concat(action.payload)} );
    }

    return state; 
};

// STORE
// reducers produce the state of your application.
export const store = createStore(
    rootReducer,
    // Add the following line for Redux DevTools
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
    );

// ACTIONS
// It is a best pratice to wrap every action within a function. 
// Such function is an action creator.
function addArticle(payload) {
    return { type: ADD_ARTICLE, payload }
  };

function deleteArticle(payload) {
    console.log("deleteArticle : ", payload);
    return { type: DELETE_ARTICLE, payload : payload }
  };

function addStudent(payload) {
    return { type: ADD_STUDENT, payload }
};

const StudentList = () => {
    const state = useSelector(state => state);
    const students = state.students || [];

    return (
        <div>
            <p>Here are all the students</p>
            <ul>
                {students.map((s, i) => <li key={i}>{s.nimi}</li>)}
            </ul>
        </div>
    )
}

function ArticleList() 
{
    const articles = useSelector(state => state.articles) || [];
    const data = articles.map( (a, index) => <li key={index}>{a.title}</li>);

    return(
        <div>
            <p>See list of articles</p>
            <ul>
                {data}
            </ul>
        </div>
    )
}

const ArticleForm = () => {
    const [title, setTitle] = useState("");
    const [id, setId] = useState(1);
    //const storeAll = useSelector(state => state);
    const dispatch = useDispatch();

    const addArticleClicked = () => {
        dispatch(addArticle({ title : title, id :id }));
        setId(id+1);
    }

    const deleteArticleClicked = () => {
        let id = parseInt(title);
        dispatch(deleteArticle({id: id, title : ''}));
    }

    return(
        <div>
            <form>
                <label htmlFor="title">Title</label>
                <input type="text" id="title" onChange={(e) => setTitle(e.target.value)}/>
            </form>
            <button onClick={() => addArticleClicked()}>Add an article</button>
            <button onClick={() => deleteArticleClicked()}>Delete an article</button>
            <button onClick={() => dispatch(addStudent({ nimi: title }))}>Add student</button>
        </div>
    )
}
