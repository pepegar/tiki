package tiki

/**
 * [[Join]] type family is used to check if an optic A composes with
 * an optic B
 */
trait Join[A] {
  type B
}

object Join {

  type Aux[AA, BB] = Join[AA] { type B = BB }

  implicit val An_IsoA_ReversedLens: Join.Aux[An_Iso, A_ReversedLens]   = new Join[An_Iso] { type B = A_ReversedLens  }
  implicit val An_IsoA_ReversedPrism: Join.Aux[An_Iso, A_ReversedPrism] = new Join[An_Iso] { type B = A_ReversedPrism }
  implicit val An_IsoA_Prism: Join.Aux[An_Iso, A_Prism]                 = new Join[An_Iso] { type B = A_Prism         }
  implicit val An_IsoA_Review: Join.Aux[An_Iso, A_Review]               = new Join[An_Iso] { type B = A_Review        }
  implicit val An_IsoA_Lens: Join.Aux[An_Iso, A_Lens]                   = new Join[An_Iso] { type B = A_Lens          }
  implicit val An_IsoA_Getter: Join.Aux[An_Iso, A_Getter]               = new Join[An_Iso] { type B = A_Getter        }
  implicit val An_IsoAn_AffineTraversal: Join.Aux[An_Iso, An_AffineTraversal] = new Join[An_Iso] {
    type B = An_AffineTraversal
  }
  implicit val An_IsoAn_AffineFold: Join.Aux[An_Iso, An_AffineFold] = new Join[An_Iso] { type B = An_AffineFold }
  implicit val An_IsoA_Traversal: Join.Aux[An_Iso, A_Traversal]     = new Join[An_Iso] { type B = A_Traversal   }
  implicit val An_IsoA_Fold: Join.Aux[An_Iso, A_Fold]               = new Join[An_Iso] { type B = A_Fold        }
  implicit val An_IsoA_Setter: Join.Aux[An_Iso, A_Setter]           = new Join[An_Iso] { type B = A_Setter      }
  // Join A_ReversedLens     An_Iso             = A_ReversedLens
  // Join A_ReversedLens     A_Prism            = A_Review
  // Join A_ReversedLens     A_Review           = A_Review
  // Join A_ReversedPrism    An_Iso             = A_ReversedPrism
  // Join A_ReversedPrism    A_Prism            = An_AffineFold
  // Join A_ReversedPrism    A_Lens             = A_Getter
  // Join A_ReversedPrism    A_Getter           = A_Getter
  // Join A_ReversedPrism    An_AffineTraversal = An_AffineFold
  // Join A_ReversedPrism    An_AffineFold      = An_AffineFold
  // Join A_ReversedPrism    A_Traversal        = A_Fold
  // Join A_ReversedPrism    A_Fold             = A_Fold
  // Join A_Prism            An_Iso             = A_Prism
  // Join A_Prism            A_ReversedLens     = A_Review
  // Join A_Prism            A_ReversedPrism    = An_AffineFold
  // Join A_Prism            A_Review           = A_Review
  // Join A_Prism            A_Lens             = An_AffineTraversal
  // Join A_Prism            A_Getter           = An_AffineFold
  // Join A_Prism            An_AffineTraversal = An_AffineTraversal
  // Join A_Prism            An_AffineFold      = An_AffineFold
  // Join A_Prism            A_Traversal        = A_Traversal
  // Join A_Prism            A_Fold             = A_Fold
  // Join A_Prism            A_Setter           = A_Setter
  // Join A_Review           An_Iso             = A_Review
  // Join A_Review           A_ReversedLens     = A_Review
  // Join A_Review           A_Prism            = A_Review
  // Join A_Lens             An_Iso             = A_Lens
  // Join A_Lens             A_ReversedPrism    = A_Getter
  // Join A_Lens             A_Prism            = An_AffineTraversal
  // Join A_Lens             A_Getter           = A_Getter
  // Join A_Lens             An_AffineTraversal = An_AffineTraversal
  // Join A_Lens             An_AffineFold      = An_AffineFold
  // Join A_Lens             A_Traversal        = A_Traversal
  // Join A_Lens             A_Fold             = A_Fold
  // Join A_Lens             A_Setter           = A_Setter
  // Join A_Getter           An_Iso             = A_Getter
  // Join A_Getter           A_ReversedPrism    = A_Getter
  // Join A_Getter           A_Prism            = An_AffineFold
  // Join A_Getter           A_Lens             = A_Getter
  // Join A_Getter           An_AffineTraversal = An_AffineFold
  // Join A_Getter           An_AffineFold      = An_AffineFold
  // Join A_Getter           A_Traversal        = A_Fold
  // Join A_Getter           A_Fold             = A_Fold
  // Join An_AffineTraversal An_Iso             = An_AffineTraversal
  // Join An_AffineTraversal A_ReversedPrism    = An_AffineFold
  // Join An_AffineTraversal A_Prism            = An_AffineTraversal
  // Join An_AffineTraversal A_Lens             = An_AffineTraversal
  // Join An_AffineTraversal A_Getter           = An_AffineFold
  // Join An_AffineTraversal An_AffineFold      = An_AffineFold
  // Join An_AffineTraversal A_Traversal        = A_Traversal
  // Join An_AffineTraversal A_Fold             = A_Fold
  // Join An_AffineTraversal A_Setter           = A_Setter
  // Join An_AffineFold      An_Iso             = An_AffineFold
  // Join An_AffineFold      A_ReversedPrism    = An_AffineFold
  // Join An_AffineFold      A_Prism            = An_AffineFold
  // Join An_AffineFold      A_Lens             = An_AffineFold
  // Join An_AffineFold      A_Getter           = An_AffineFold
  // Join An_AffineFold      An_AffineTraversal = An_AffineFold
  // Join An_AffineFold      A_Traversal        = A_Fold
  // Join An_AffineFold      A_Fold             = A_Fold
  // Join A_Traversal        An_Iso             = A_Traversal
  // Join A_Traversal        A_ReversedPrism    = A_Fold
  // Join A_Traversal        A_Prism            = A_Traversal
  // Join A_Traversal        A_Lens             = A_Traversal
  // Join A_Traversal        A_Getter           = A_Fold
  // Join A_Traversal        An_AffineTraversal = A_Traversal
  // Join A_Traversal        An_AffineFold      = A_Fold
  // Join A_Traversal        A_Fold             = A_Fold
  // Join A_Traversal        A_Setter           = A_Setter
  // Join A_Fold             An_Iso             = A_Fold
  // Join A_Fold             A_ReversedPrism    = A_Fold
  // Join A_Fold             A_Prism            = A_Fold
  // Join A_Fold             A_Lens             = A_Fold
  // Join A_Fold             A_Getter           = A_Fold
  // Join A_Fold             An_AffineTraversal = A_Fold
  // Join A_Fold             An_AffineFold      = A_Fold
  // Join A_Fold             A_Traversal        = A_Fold
  // Join A_Setter           An_Iso             = A_Setter
  // Join A_Setter           A_Prism            = A_Setter
  // Join A_Setter           A_Lens             = A_Setter
  // Join A_Setter           An_AffineTraversal = A_Setter
  // Join A_Setter           A_Traversal        = A_Setter
  //  Join k k = k

}
