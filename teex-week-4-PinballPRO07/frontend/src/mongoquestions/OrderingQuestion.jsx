import { useState } from "react";
import Question from "../openquestions/Question";
import { Button, Paper, Typography } from "@mui/material";
import ArrowUpwardIcon from "@mui/icons-material/ArrowUpward";
import ArrowDownwardIcon from "@mui/icons-material/ArrowDownward";

export default function OrderingQuestion({ question }) {
  const [items, setItems] = useState(
    question.items ? [...question.items].sort(() => Math.random() - 0.5) : []
  );

  const moveUp = (index) => {
    if (index === 0) return;
    const updated = [...items];
    [updated[index - 1], updated[index]] = [updated[index], updated[index - 1]];
    setItems(updated);
  };

  const moveDown = (index) => {
    if (index === items.length - 1) return;
    const updated = [...items];
    [updated[index], updated[index + 1]] = [updated[index + 1], updated[index]];
    setItems(updated);
  };

  return (
    <>
      <h4>Volgorde vraag</h4>
      <Question
        question={question}
        answerInput={
          <div style={{ margin: "12px" }}>
            {items.map((item, i) => (
              <Paper
                key={i}
                elevation={2}
                sx={{
                  display: "flex",
                  alignItems: "center",
                  justifyContent: "space-between",
                  padding: "8px 16px",
                  marginBottom: "8px",
                }}
              >
                <Typography>{i + 1}. {item.text}</Typography>
                <div>
                  <Button size="small" onClick={() => moveUp(i)} disabled={i === 0}>
                    <ArrowUpwardIcon fontSize="small" />
                  </Button>
                  <Button size="small" onClick={() => moveDown(i)} disabled={i === items.length - 1}>
                    <ArrowDownwardIcon fontSize="small" />
                  </Button>
                </div>
              </Paper>
            ))}
          </div>
        }
      />
    </>
  );
}