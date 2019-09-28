package cats

trait Bicontravariant[P[_, _]] {
  def contrabimap[A, B, C, D](ba: B => A, dc: D => C)(pac: P[A, C]): P[B, D]
  def contrafirst[A, B, C, D](ba: B => A)(pac: P[A, C]): P[B, C]
  def contrasecond[A, B, C, D](cb: C => B)(pab: P[A, B]): P[A, C]
}
