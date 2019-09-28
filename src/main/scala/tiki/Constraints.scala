package tiki

import cats.Bifunctor
import cats.Bicontravariant
import cats.arrow._

trait Constraints[K, O[_, _]] {
  type Constraint
}

object Constraints {

  type Aux[K, O[_, _], C] = Constraints[K, O] { type Constraint = C }

  implicit def Constraints_An_Iso[P[_, _]]: Constraints.Aux[An_Iso, P, Profunctor[P]] =
    new Constraints[An_Iso, P] { type Constraint = Profunctor[P] }
  implicit def Constraints_A_Lens[P[_, _]]: Constraints.Aux[A_Lens, P, Strong[P]] = new Constraints[A_Lens, P] {
    type Constraint = Strong[P]
  }
  implicit def Constraints_A_ReversedLens[P[_, _]]: Constraints.Aux[A_ReversedLens, P, Costrong[P]] =
    new Constraints[A_ReversedLens, P] { type Constraint = Costrong[P] }
  implicit def Constraints_A_Prism[P[_, _]]: Constraints.Aux[A_Prism, P, Choice[P]] =
    new Constraints[A_Prism, P] { type Constraint = Choice[P] }
  implicit def Constraints_A_ReversedPrism[P[_, _]]: Constraints.Aux[A_ReversedPrism, P, Cochoice[P]] =
    new Constraints[A_ReversedPrism, P] { type Constraint = Cochoice[P] }
  implicit def Constraints_An_AffineTraversal[P[_, _]]: Constraints.Aux[An_AffineTraversal, P, Visiting[P]] =
    new Constraints[An_AffineTraversal, P] { type Constraint = Visiting[P] }
  implicit def Constraints_A_Traversal[P[_, _]]: Constraints.Aux[A_Traversal, P, Traversing[P]] =
    new Constraints[A_Traversal, P] { type Constraint = Traversing[P] }
  implicit def Constraints_A_Setter[P[_, _]]: Constraints.Aux[A_Setter, P, Mapping[P]] =
    new Constraints[A_Setter, P] { type Constraint = Mapping[P] }
  implicit def Constraints_A_Getter[P[_, _]]: Constraints.Aux[
    A_Getter,
    P,
    (Bicontravariant[P], Cochoice[P], Strong[P])] =
    new Constraints[A_Getter, P] {
      type Constraint = (Bicontravariant[P], Cochoice[P], Strong[P])
    }
  implicit def Constraints_An_AffineFold[P[_, _]]: Constraints.Aux[
    An_AffineFold,
    P,
    (Bicontravariant[P], Cochoice[P], Visiting[P])] =
    new Constraints[An_AffineFold, P] {
      type Constraint = (Bicontravariant[P], Cochoice[P], Visiting[P])
    }
  implicit def Constraints_A_Fold[P[_, _]]: Constraints.Aux[
    A_Fold,
    P,
    (Bicontravariant[P], Cochoice[P], Traversing[P])] =
    new Constraints[A_Fold, P] {
      type Constraint = (Bicontravariant[P], Cochoice[P], Traversing[P])
    }
  implicit def Constraints_A_Review[P[_, _]]: Constraints.Aux[A_Review, P, (Bifunctor[P], Choice[P], Costrong[P])] =
    new Constraints[A_Review, P] {
      type Constraint = (Bifunctor[P], Choice[P], Costrong[P])
    }

}
