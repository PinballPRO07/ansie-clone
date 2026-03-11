import NavigationButton from "./NavigationButton";

export default function Navigator({ currentIndex, total, next, previous }) {
  const isFirst = currentIndex === 0;
  const isLast = currentIndex === total - 1;

  return (
    <div className="navigation">
      {!isFirst && <NavigationButton action={previous} title="Vorige" />}
      {!isLast && <NavigationButton action={next} title="Volgende" />}
    </div>
  );
}