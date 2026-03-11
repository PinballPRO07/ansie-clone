import { useState } from "react";
import Question from "../openquestions/Question.jsx";
import {
  FormControl,
  FormControlLabel,
  Radio,
  RadioGroup,
} from "@mui/material";

export default function MCQuestion({ question }) {
  const [selected, setSelected] = useState("");

  return (
    <>
      <h4>Meerkeuze vraag</h4>
      <Question
        question={question}
        answerInput={
          <FormControl sx={{ margin: 2, width: "90%" }}>
            <RadioGroup
              value={selected}
              onChange={(e) => setSelected(e.target.value)}
            >
              {question.options?.map((option, i) => (
                <FormControlLabel
                  key={i}
                  value={option.text}
                  control={<Radio />}
                  label={option.text}
                />
              ))}
            </RadioGroup>
          </FormControl>
        }
      />
    </>
  );
}