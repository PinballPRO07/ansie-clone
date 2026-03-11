import "./App.css";
import React, { useEffect, useState } from "react";
import Navigator from "./openquestions/Navigator";
import fetchQuestion from "./restGateway/RestGateway";
import OpenQuestion from "./openquestions/OpenQuestion";
import AppTopBar from "./openquestions/AppTopBar";

function App() {
  const [question, setQuestion] = useState({
    id: 0,
    title: "",
    description: "",
    type: "",
    options: [],
  });
  const [index, setIndex] = useState(1);

  useEffect(() => {
    fetchQuestion(index, setQuestion, setIndex);
  }, [index]);

  const next = async () => {
    setIndex(index + 1);
  };
  const previous = async () => {
    setIndex(index - 1);
  };

  return (
    <div className="App">
      <AppTopBar barTitle="ANSIE" />
      <div className="box">
        <OpenQuestion key={question.id} question={question} />
        <Navigator
          currentQuestionId={question.id}
          next={next}
          previous={previous}
        />
      </div>
    </div>
  );
}

export default App;
