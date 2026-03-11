export default function Question(props) {
  return (
    <div className="question" key={props.question.id}>
      <h2 className="question__title">{props.question.title}</h2>
      {props.answerInput}
    </div>
  );
}
