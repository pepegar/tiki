package tiki

import cats.Functor
import cats.arrow.{Choice, Strong}

/**
 * Universally quantified function `forall f a . a -> f a`?
 */
trait Algebra {
  type F[_]
  type A
  def alg(a: A): F[A]
}

object Algebra {
  type Aux[FF[_], AA] = Algebra {
    type F[_] = FF
    type A    = AA
  }

  def apply[FF[_], AA](f: AA => FF[AA]): Algebra.Aux[FF, AA] = new Algebra {
    type F[_] = FF
    type A    = AA
    def alg(a: AA): FF[A] = f(a)
  }
}

trait Visiting[P[_, _]] extends Choice[P] with Strong[P] {
  def visit[F[_]: Functor, R, S, T, A, B](f: Algebra)(afb: A => F[B])(sft: S => F[T])(p: P[A, B]): P[S, T] = {}
}
