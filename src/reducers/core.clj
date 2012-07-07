(ns reducers.core
  (:require [clojure.core.reducers :as r]))

(map + [1 2 3]) ;=> (1 2 3)
(class(map + [1 2 3]))    ;=> (1 2 3)

(def odyssey-text (slurp "odyssey.txt"))
(class odyssey-text) ;=> java.lang.String

(first odyssey-text) ;=> \P
(class (first odyssey-text)) ;=> java.lang.Character
(.hashCode (first odyssey-text)) ;=> 80
(.hashCode (second odyssey-text)) ;=> 114
(.hashCode (nth odyssey-text 2)) ;=> 111

(defn hashcode [c] (.hashCode c))
(map hashcode odyssey-text) ;=> (80 114 111..... )
(filter even? (map hashcode odyssey-text)) ;=> (80 114 ... )
(reduce + (filter even? (map hashcode odyssey-text))) ;=> 33702446

(dotimes [n 5]
  (println (str "map - filter - reduce - ( run " n " ):"))
  (time (reduce + (filter even? (map hashcode odyssey-text)))))

(reduce + (r/filter even? (r/map hashcode odyssey-text))) ;=> 33702446

(dotimes [n 5]
  (println (str "r/map - r/filter - reduce - ( run " n " ):"))
  (time (reduce + (r/filter even? (r/map hashcode odyssey-text)))))

(into [] (r/filter even? (r/map hashcode odyssey-text))) ;=> [80 114 ... ]



