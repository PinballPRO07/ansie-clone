import NavigationButton from "./NavigationButton";

export default function Navigator({ currentQuestionId, next, previous }) {
  if (currentQuestionId === 1) {
    return (
      <div className="navigation">
        <NavigationButton action={next} title="Volgende" />
      </div>
    );
  }
  if (currentQuestionId >= 2 && currentQuestionId < 4) {
    return (
      <div className="navigation">
        <NavigationButton action={previous} title="Vorige" />
        <NavigationButton action={next} title="Volgende" />
      </div>
    );
  }
  if (currentQuestionId === 4) {
    return (
      <div className="navigation">
        <NavigationButton action={previous} title="Vorige" />
      </div>
    );
  }
}
