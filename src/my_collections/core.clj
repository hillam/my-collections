(ns my-collections.core
  (:gen-class))

(defn first
  [[head & tail]]
  head
)

(defn rest
  [[head & tail]]
  tail
)

