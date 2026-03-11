import axios from "axios";

const BASE_URL = "http://localhost:8080/api";

/**
 * Fetch all questions from MongoDB, then navigate by index.
 */
const fetchAllQuestions = (setQuestions) => {
  return axios(`${BASE_URL}/examQuestions`)
    .then((response) => {
      setQuestions(response.data);
      return response.data;
    })
    .catch((error) => {
      console.error("Error fetching questions:", error);
    });
};

/**
 * Fetch a single question by its MongoDB _id.
 */
const fetchQuestionById = (id, setQuestion) => {
  return axios(`${BASE_URL}/examQuestions/${id}`)
    .then((response) => {
      setQuestion(response.data);
      return response.data;
    })
    .catch((error) => {
      console.error("Error fetching question by id:", error);
    });
};

export { fetchAllQuestions, fetchQuestionById };