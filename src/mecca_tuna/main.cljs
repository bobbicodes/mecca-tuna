(ns mecca-tuna.main
  (:require [reagent.core :as r]))

(defn app []
  [:div 
   ;[:h1 "hi"]
   ])

(defn ^:dev/after-load start []
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init
  []
  (start))