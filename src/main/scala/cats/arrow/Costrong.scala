package cats.arrow

trait Costrong[P[_, _]] extends Profunctor[P] {
  def unfirst[A, B, D](p: P[(A, D), (B, D)]): P[A, B]
  def unsecond[A, B, D](p: P[(D, A), (D, B)]): P[A, B]
}
