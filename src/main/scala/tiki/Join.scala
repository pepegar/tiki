package tiki

/**
 * [[Join]] type family is used to check if an optic A composes with
 * an optic B
 */
trait Join[A, B] {
  type Result
}

object Join {

  type Aux[A, B, RResult] = Join[A, B] { type Result = RResult }

  // format: off
  implicit val An_Iso_A_ReversedLens: Join.Aux[An_Iso, A_ReversedLens, A_ReversedLens]                          = new Join[An_Iso, A_ReversedLens]              { type Result = A_ReversedLens     }
  implicit val An_Iso_A_ReversedPrism: Join.Aux[An_Iso, A_ReversedPrism, A_ReversedPrism]                       = new Join[An_Iso, A_ReversedPrism]             { type Result = A_ReversedPrism    }
  implicit val An_Iso_A_Prism: Join.Aux[An_Iso, A_Prism, A_Prism]                                               = new Join[An_Iso, A_Prism]                     { type Result = A_Prism            }
  implicit val An_Iso_A_Review: Join.Aux[An_Iso, A_Review, A_Review]                                            = new Join[An_Iso, A_Review]                    { type Result = A_Review           }
  implicit val An_Iso_A_Lens: Join.Aux[An_Iso, A_Lens, A_Lens]                                                  = new Join[An_Iso, A_Lens]                      { type Result = A_Lens             }
  implicit val An_Iso_A_Getter: Join.Aux[An_Iso, A_Getter, A_Getter]                                            = new Join[An_Iso, A_Getter]                    { type Result = A_Getter           }
  implicit val An_Iso_A_AffineTraversal: Join.Aux[An_Iso, An_AffineTraversal, An_AffineTraversal]               = new Join[An_Iso, An_AffineTraversal]          { type Result = An_AffineTraversal }
  implicit val An_Iso_A_AffineFold: Join.Aux[An_Iso, An_AffineFold, An_AffineFold]                              = new Join[An_Iso, An_AffineFold]               { type Result = An_AffineFold      }
  implicit val An_Iso_A_Traversal: Join.Aux[An_Iso, A_Traversal, A_Traversal]                                   = new Join[An_Iso, A_Traversal]                 { type Result = A_Traversal        }
  implicit val An_Iso_A_Fold: Join.Aux[An_Iso, A_Fold, A_Fold]                                                  = new Join[An_Iso, A_Fold]                      { type Result = A_Fold             }
  implicit val An_Iso_A_Setter: Join.Aux[An_Iso, A_Setter, A_Setter]                                            = new Join[An_Iso, A_Setter]                    { type Result = A_Setter           }
  implicit val A_ReversedLens_A_Iso: Join.Aux[A_ReversedLens, An_Iso, A_ReversedLens]                           = new Join[A_ReversedLens, An_Iso]              { type Result = A_ReversedLens     }
  implicit val A_ReversedLens_A_Prism: Join.Aux[A_ReversedLens, A_Prism, A_Review]                              = new Join[A_ReversedLens, A_Prism]             { type Result = A_Review           }
  implicit val A_ReversedLens_A_Review: Join.Aux[A_ReversedLens, A_Review, A_Review]                            = new Join[A_ReversedLens, A_Review]            { type Result = A_Review           }
  implicit val A_ReversedPrism_A_Iso: Join.Aux[A_ReversedPrism, An_Iso, A_ReversedPrism]                        = new Join[A_ReversedPrism, An_Iso]             { type Result = A_ReversedPrism    }
  implicit val A_ReversedPrism_A_Prism: Join.Aux[A_ReversedPrism, A_Prism, An_AffineFold]                       = new Join[A_ReversedPrism, A_Prism]            { type Result = An_AffineFold      }
  implicit val A_ReversedPrism_A_Lens: Join.Aux[A_ReversedPrism, A_Lens, A_Getter]                              = new Join[A_ReversedPrism, A_Lens]             { type Result = A_Getter           }
  implicit val A_ReversedPrism_A_Getter: Join.Aux[A_ReversedPrism, A_Getter, A_Getter]                          = new Join[A_ReversedPrism, A_Getter]           { type Result = A_Getter           }
  implicit val A_ReversedPrism_A_AffineTraversal: Join.Aux[A_ReversedPrism, An_AffineTraversal, An_AffineFold]  = new Join[A_ReversedPrism, An_AffineTraversal] { type Result = An_AffineFold      }
  implicit val A_ReversedPrism_A_AffineFold: Join.Aux[A_ReversedPrism, An_AffineFold, An_AffineFold]            = new Join[A_ReversedPrism, An_AffineFold]      { type Result = An_AffineFold      }
  implicit val A_ReversedPrism_A_Traversal: Join.Aux[A_ReversedPrism, A_Traversal, A_Fold]                      = new Join[A_ReversedPrism, A_Traversal]        { type Result = A_Fold             }
  implicit val A_ReversedPrism_A_Fold: Join.Aux[A_ReversedPrism, A_Fold, A_Fold]                                = new Join[A_ReversedPrism, A_Fold]             { type Result = A_Fold             }
  implicit val A_Prism_A_Iso: Join.Aux[A_Prism, An_Iso, A_Prism]                                                = new Join[A_Prism, An_Iso]                     { type Result = A_Prism            }
  implicit val A_Prism_A_ReversedLens: Join.Aux[A_Prism, A_ReversedLens, A_Review]                              = new Join[A_Prism, A_ReversedLens]             { type Result = A_Review           }
  implicit val A_Prism_A_ReversedPrism: Join.Aux[A_Prism, A_ReversedPrism, An_AffineFold]                       = new Join[A_Prism, A_ReversedPrism]            { type Result = An_AffineFold      }
  implicit val A_Prism_A_Review: Join.Aux[A_Prism, A_Review, A_Review]                                          = new Join[A_Prism, A_Review]                   { type Result = A_Review           }
  implicit val A_Prism_A_Lens: Join.Aux[A_Prism, A_Lens, An_AffineTraversal]                                    = new Join[A_Prism, A_Lens]                     { type Result = An_AffineTraversal }
  implicit val A_Prism_A_Getter: Join.Aux[A_Prism, A_Getter, An_AffineFold]                                     = new Join[A_Prism, A_Getter]                   { type Result = An_AffineFold      }
  implicit val A_Prism_A_AffineTraversal: Join.Aux[A_Prism, An_AffineTraversal, An_AffineTraversal]             = new Join[A_Prism, An_AffineTraversal]         { type Result = An_AffineTraversal }
  implicit val A_Prism_A_AffineFold: Join.Aux[A_Prism, An_AffineFold, An_AffineFold]                            = new Join[A_Prism, An_AffineFold]              { type Result = An_AffineFold      }
  implicit val A_Prism_A_Traversal: Join.Aux[A_Prism, A_Traversal, A_Traversal]                                 = new Join[A_Prism, A_Traversal]                { type Result = A_Traversal        }
  implicit val A_Prism_A_Fold: Join.Aux[A_Prism, A_Fold, A_Fold]                                                = new Join[A_Prism, A_Fold]                     { type Result = A_Fold             }
  implicit val A_Prism_A_Setter: Join.Aux[A_Prism, A_Setter, A_Setter]                                          = new Join[A_Prism, A_Setter]                   { type Result = A_Setter           }
  implicit val A_Review_A_Iso: Join.Aux[A_Review, An_Iso, A_Review]                                             = new Join[A_Review, An_Iso]                    { type Result = A_Review           }
  implicit val A_Review_A_ReversedLens: Join.Aux[A_Review, A_ReversedLens, A_Review]                            = new Join[A_Review, A_ReversedLens]            { type Result = A_Review           }
  implicit val A_Review_A_Prism: Join.Aux[A_Review, A_Prism, A_Review]                                          = new Join[A_Review, A_Prism]                   { type Result = A_Review           }
  implicit val A_Lens_A_Iso: Join.Aux[A_Lens, An_Iso, A_Lens]                                                   = new Join[A_Lens, An_Iso]                      { type Result = A_Lens             }
  implicit val A_Lens_A_ReversedPrism: Join.Aux[A_Lens, A_ReversedPrism, A_Getter]                              = new Join[A_Lens, A_ReversedPrism]             { type Result = A_Getter           }
  implicit val A_Lens_A_Prism: Join.Aux[A_Lens, A_Prism, An_AffineTraversal]                                    = new Join[A_Lens, A_Prism]                     { type Result = An_AffineTraversal }
  implicit val A_Lens_A_Getter: Join.Aux[A_Lens, A_Getter, A_Getter]                                            = new Join[A_Lens, A_Getter]                    { type Result = A_Getter           }
  implicit val A_Lens_A_AffineTraversal: Join.Aux[A_Lens, An_AffineTraversal, An_AffineTraversal]               = new Join[A_Lens, An_AffineTraversal]          { type Result = An_AffineTraversal }
  implicit val A_Lens_A_AffineFold: Join.Aux[A_Lens, An_AffineFold, An_AffineFold]                              = new Join[A_Lens, An_AffineFold]               { type Result = An_AffineFold      }
  implicit val A_Lens_A_Traversal: Join.Aux[A_Lens, A_Traversal, A_Traversal]                                   = new Join[A_Lens, A_Traversal]                 { type Result = A_Traversal        }
  implicit val A_Lens_A_Fold: Join.Aux[A_Lens, A_Fold, A_Fold]                                                  = new Join[A_Lens, A_Fold]                      { type Result = A_Fold             }
  implicit val A_Lens_A_Setter: Join.Aux[A_Lens, A_Setter, A_Setter]                                            = new Join[A_Lens, A_Setter]                    { type Result = A_Setter           }
  implicit val A_Getter_A_Iso: Join.Aux[A_Getter, An_Iso, A_Getter]                                             = new Join[A_Getter, An_Iso]                    { type Result = A_Getter           }
  implicit val A_Getter_A_ReversedPrism: Join.Aux[A_Getter, A_ReversedPrism, A_Getter]                          = new Join[A_Getter, A_ReversedPrism]           { type Result = A_Getter           }
  implicit val A_Getter_A_Prism: Join.Aux[A_Getter, A_Prism, An_AffineFold]                                     = new Join[A_Getter, A_Prism]                   { type Result = An_AffineFold      }
  implicit val A_Getter_A_Lens: Join.Aux[A_Getter, A_Lens, A_Getter]                                            = new Join[A_Getter, A_Lens]                    { type Result = A_Getter           }
  implicit val A_Getter_A_AffineTraversal: Join.Aux[A_Getter, An_AffineTraversal, An_AffineFold]                = new Join[A_Getter, An_AffineTraversal]        { type Result = An_AffineFold      }
  implicit val A_Getter_A_AffineFold: Join.Aux[A_Getter, An_AffineFold, An_AffineFold]                          = new Join[A_Getter, An_AffineFold]             { type Result = An_AffineFold      }
  implicit val A_Getter_A_Traversal: Join.Aux[A_Getter, A_Traversal, A_Fold]                                    = new Join[A_Getter, A_Traversal]               { type Result = A_Fold             }
  implicit val A_Getter_A_Fold: Join.Aux[A_Getter, A_Fold, A_Fold]                                              = new Join[A_Getter, A_Fold]                    { type Result = A_Fold             }
  implicit val An_AffineTraversal_A_Iso: Join.Aux[An_AffineTraversal, An_Iso, An_AffineTraversal]               = new Join[An_AffineTraversal, An_Iso]          { type Result = An_AffineTraversal }
  implicit val An_AffineTraversal_A_ReversedPrism: Join.Aux[An_AffineTraversal, A_ReversedPrism, An_AffineFold] = new Join[An_AffineTraversal, A_ReversedPrism] { type Result = An_AffineFold      }
  implicit val An_AffineTraversal_A_Prism: Join.Aux[An_AffineTraversal, A_Prism, An_AffineTraversal]            = new Join[An_AffineTraversal, A_Prism]         { type Result = An_AffineTraversal }
  implicit val An_AffineTraversal_A_Lens: Join.Aux[An_AffineTraversal, A_Lens, An_AffineTraversal]              = new Join[An_AffineTraversal, A_Lens]          { type Result = An_AffineTraversal }
  implicit val An_AffineTraversal_A_Getter: Join.Aux[An_AffineTraversal, A_Getter, An_AffineFold]               = new Join[An_AffineTraversal, A_Getter]        { type Result = An_AffineFold      }
  implicit val An_AffineTraversal_A_AffineFold: Join.Aux[An_AffineTraversal, An_AffineFold, An_AffineFold]      = new Join[An_AffineTraversal, An_AffineFold]   { type Result = An_AffineFold      }
  implicit val An_AffineTraversal_A_Traversal: Join.Aux[An_AffineTraversal, A_Traversal, A_Traversal]           = new Join[An_AffineTraversal, A_Traversal]     { type Result = A_Traversal        }
  implicit val An_AffineTraversal_A_Fold: Join.Aux[An_AffineTraversal, A_Fold, A_Fold]                          = new Join[An_AffineTraversal, A_Fold]          { type Result = A_Fold             }
  implicit val An_AffineTraversal_A_Setter: Join.Aux[An_AffineTraversal, A_Setter, A_Setter]                    = new Join[An_AffineTraversal, A_Setter]        { type Result = A_Setter           }
  implicit val An_AffineFold_A_Iso: Join.Aux[An_AffineFold, An_Iso, An_AffineFold]                              = new Join[An_AffineFold, An_Iso]               { type Result = An_AffineFold      }
  implicit val An_AffineFold_A_ReversedPrism: Join.Aux[An_AffineFold, A_ReversedPrism, An_AffineFold]           = new Join[An_AffineFold, A_ReversedPrism]      { type Result = An_AffineFold      }
  implicit val An_AffineFold_A_Prism: Join.Aux[An_AffineFold, A_Prism, An_AffineFold]                           = new Join[An_AffineFold, A_Prism]              { type Result = An_AffineFold      }
  implicit val An_AffineFold_A_Lens: Join.Aux[An_AffineFold, A_Lens, An_AffineFold]                             = new Join[An_AffineFold, A_Lens]               { type Result = An_AffineFold      }
  implicit val An_AffineFold_A_Getter: Join.Aux[An_AffineFold, A_Getter, An_AffineFold]                         = new Join[An_AffineFold, A_Getter]             { type Result = An_AffineFold      }
  implicit val An_AffineFold_A_AffineTraversal: Join.Aux[An_AffineFold, An_AffineTraversal, An_AffineFold]      = new Join[An_AffineFold, An_AffineTraversal]   { type Result = An_AffineFold      }
  implicit val An_AffineFold_A_Traversal: Join.Aux[An_AffineFold, A_Traversal, A_Fold]                          = new Join[An_AffineFold, A_Traversal]          { type Result = A_Fold             }
  implicit val An_AffineFold_A_Fold: Join.Aux[An_AffineFold, A_Fold, A_Fold]                                    = new Join[An_AffineFold, A_Fold]               { type Result = A_Fold             }
  implicit val A_Traversal_A_Iso: Join.Aux[A_Traversal, An_Iso, A_Traversal]                                    = new Join[A_Traversal, An_Iso]                 { type Result = A_Traversal        }
  implicit val A_Traversal_A_ReversedPrism: Join.Aux[A_Traversal, A_ReversedPrism, A_Fold]                      = new Join[A_Traversal, A_ReversedPrism]        { type Result = A_Fold             }
  implicit val A_Traversal_A_Prism: Join.Aux[A_Traversal, A_Prism, A_Traversal]                                 = new Join[A_Traversal, A_Prism]                { type Result = A_Traversal        }
  implicit val A_Traversal_A_Lens: Join.Aux[A_Traversal, A_Lens, A_Traversal]                                   = new Join[A_Traversal, A_Lens]                 { type Result = A_Traversal        }
  implicit val A_Traversal_A_Getter: Join.Aux[A_Traversal, A_Getter, A_Fold]                                    = new Join[A_Traversal, A_Getter]               { type Result = A_Fold             }
  implicit val A_Traversal_A_AffineTraversal: Join.Aux[A_Traversal, An_AffineTraversal, A_Traversal]            = new Join[A_Traversal, An_AffineTraversal]     { type Result = A_Traversal        }
  implicit val A_Traversal_A_AffineFold: Join.Aux[A_Traversal, An_AffineFold, A_Fold]                           = new Join[A_Traversal, An_AffineFold]          { type Result = A_Fold             }
  implicit val A_Traversal_A_Fold: Join.Aux[A_Traversal, A_Fold, A_Fold]                                        = new Join[A_Traversal, A_Fold]                 { type Result = A_Fold             }
  implicit val A_Traversal_A_Setter: Join.Aux[A_Traversal, A_Setter, A_Setter]                                  = new Join[A_Traversal, A_Setter]               { type Result = A_Setter           }
  implicit val A_Fold_A_Iso: Join.Aux[A_Fold, An_Iso, A_Fold]                                                   = new Join[A_Fold, An_Iso]                      { type Result = A_Fold             }
  implicit val A_Fold_A_ReversedPrism: Join.Aux[A_Fold, A_ReversedPrism, A_Fold]                                = new Join[A_Fold, A_ReversedPrism]             { type Result = A_Fold             }
  implicit val A_Fold_A_Prism: Join.Aux[A_Fold, A_Prism, A_Fold]                                                = new Join[A_Fold, A_Prism]                     { type Result = A_Fold             }
  implicit val A_Fold_A_Lens: Join.Aux[A_Fold, A_Lens, A_Fold]                                                  = new Join[A_Fold, A_Lens]                      { type Result = A_Fold             }
  implicit val A_Fold_A_Getter: Join.Aux[A_Fold, A_Getter, A_Fold]                                              = new Join[A_Fold, A_Getter]                    { type Result = A_Fold             }
  implicit val A_Fold_A_AffineTraversal: Join.Aux[A_Fold, An_AffineTraversal, A_Fold]                           = new Join[A_Fold, An_AffineTraversal]          { type Result = A_Fold             }
  implicit val A_Fold_A_AffineFold: Join.Aux[A_Fold, An_AffineFold, A_Fold]                                     = new Join[A_Fold, An_AffineFold]               { type Result = A_Fold             }
  implicit val A_Fold_A_Traversal: Join.Aux[A_Fold, A_Traversal, A_Fold]                                        = new Join[A_Fold, A_Traversal]                 { type Result = A_Fold             }
  implicit val A_Setter_A_Iso: Join.Aux[A_Setter, An_Iso, A_Setter]                                             = new Join[A_Setter, An_Iso]                    { type Result = A_Setter           }
  implicit val A_Setter_A_Prism: Join.Aux[A_Setter, A_Prism, A_Setter]                                          = new Join[A_Setter, A_Prism]                   { type Result = A_Setter           }
  implicit val A_Setter_A_Lens: Join.Aux[A_Setter, A_Lens, A_Setter]                                            = new Join[A_Setter, A_Lens]                    { type Result = A_Setter           }
  implicit val A_Setter_A_AffineTraversal: Join.Aux[A_Setter, An_AffineTraversal, A_Setter]                     = new Join[A_Setter, An_AffineTraversal]        { type Result = A_Setter           }
  implicit val A_Setter_A_Traversal: Join.Aux[A_Setter, A_Traversal, A_Setter]                                  = new Join[A_Setter, A_Traversal]               { type Result = A_Setter           }
  implicit def refl[A]: Join.Aux[A, A, A]                                                                       = new Join[A, A]                                { type Result = A                  }
  // format: on

}
