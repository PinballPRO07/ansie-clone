import axios from "axios";

const fetchQuestion = (index, setQuestion, setIndex) => {
  axios("http://localhost:8080/api/examQuestions/open/" + index)
    .then((response) => {
      setQuestion(response.data);
      setIndex(index);
    })
    .catch((error) => {
      console.log(error);
    });
};

export default fetchQuestion;
