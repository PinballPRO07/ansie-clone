import Question from "./Question";
import { TextField } from "@mui/material";

export default function OpenQuestion({ question }) {
  return (
    <>
      <h4>Open vraag</h4>
      <Question
        question={question}
        answerInput={
          <TextField
            fullWidth
            label={question.description}
            id={question.id}
            name={question.description}
          />
        }
      />
    </>
  );
}
