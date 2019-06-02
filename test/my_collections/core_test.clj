(ns my-collections.core-test
  (:require [clojure.test :refer :all]
            [my-collections.core :refer :all :as my]))

; Vector of test cases
(def test-colls [
  (range 1 10)
  (seq (range 1 10))
  (list (range 1 10))
  (vector (range 1 10))
  (list "1" "2" "3")
  {:a 1 :b 2}
  1
  "banana"
  :definitely-a-collection
])

(defn compare-fns
  "Test that the results of the two given functions are the same
  for all given collections."
  [my-fn core-fn coll]
    (try
      (core-fn coll)
      (is
        (= (my-fn coll)
           (core-fn coll)))
      (catch Exception e
        (is (thrown? Exception (my-fn coll)))))
)

(deftest first-test
  (doseq
    [coll test-colls]
    (testing "my/first should always match clojure.core's"
      (compare-fns my/first clojure.core/first coll)))
)

(deftest rest-test
  (doseq
    [coll test-colls]
    (testing "my/rest should always match clojure.core's"
      (compare-fns my/rest clojure.core/rest coll)))
)

