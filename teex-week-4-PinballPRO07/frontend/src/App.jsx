import "./App.css";
import React, { useEffect, useState } from "react";
import { fetchAllQuestions } from "./restGateway/RestGateway";
import AppTopBar from "./openquestions/AppTopBar";
import Navigator from "./openquestions/Navigator";
import OpenQuestion from "./openquestions/OpenQuestion.jsx";
import MCQuestion from "./mongoquestions/MCQuestion.jsx";
import MatchingQuestion from "./mongoquestions/MatchingQuestion.jsx";
import OrderingQuestion from "./mongoquestions/OrderingQuestion.jsx";

function App() {
  const [questions, setQuestions] = useState([]);
  const [index, setIndex] = useState(0);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    fetchAllQuestions(setQuestions).finally(() => setLoading(false));
  }, []);

  const question = questions[index];

  const next = () => {
    if (index < questions.length - 1) setIndex(index + 1);
  };

  const previous = () => {
    if (index > 0) setIndex(index - 1);
  };

  const renderQuestion = () => {
    if (!question) return null;
    switch (question.type) {
      case "mc":       return <MCQuestion question={question} />;
      case "ordering": return <OrderingQuestion question={question} />;
      case "matching": return <MatchingQuestion question={question} />;
      case "open":
      default:         return <OpenQuestion question={question} />;
    }
  };

  return (
    <div className="App">
      <AppTopBar barTitle="ANSIE" />
      {loading ? (
        <p style={{ margin: "2rem" }}>Vragen laden...</p>
      ) : (
        <div className="box">
          {renderQuestion()}
          <Navigator
            currentIndex={index}
            total={questions.length}
            next={next}
            previous={previous}
          />
        </div>
      )}
    </div>
  );
}

export default App;