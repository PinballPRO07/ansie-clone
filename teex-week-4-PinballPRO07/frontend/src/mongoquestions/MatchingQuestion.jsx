import { useState } from "react";
import Question from "../openquestions/Question.jsx";
import { FormControl, InputLabel, Select, MenuItem, Box, Typography } from "@mui/material";

export default function MatchingQuestion({ question }) {
  const pairs = question.matchPairs || [];
  const rightOptions = [...pairs].sort(() => Math.random() - 0.5).map((p) => p.right);

  const [answers, setAnswers] = useState(
    Object.fromEntries(pairs.map((p) => [p.left, ""]))
  );

  const handleChange = (left, value) => {
    setAnswers((prev) => ({ ...prev, [left]: value }));
  };

  return (
    <>
      <h4>Koppel vraag</h4>
      <Question
        question={question}
        answerInput={
          <Box sx={{ margin: 2 }}>
            {pairs.map((pair, i) => (
              <Box
                key={i}
                sx={{
                  display: "flex",
                  alignItems: "center",
                  gap: 2,
                  marginBottom: 2,
                }}
              >
                <Typography sx={{ minWidth: 80, fontWeight: 500 }}>
                  {pair.left}
                </Typography>
                <FormControl sx={{ minWidth: 280 }}>
                  <InputLabel>Kies een antwoord</InputLabel>
                  <Select
                    value={answers[pair.left]}
                    label="Kies een antwoord"
                    onChange={(e) => handleChange(pair.left, e.target.value)}
                  >
                    {rightOptions.map((opt, j) => (
                      <MenuItem key={j} value={opt}>
                        {opt}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
              </Box>
            ))}
          </Box>
        }
      />
    </>
  );
}