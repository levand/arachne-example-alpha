(ns arachne.example.alpha.web
  (:require [ring.util.response :as ring-resp]
            [clojure.string :as str]
            [io.pedestal.interceptor :as i]))

(defn hello-world-handler
  "Constructor for a hello-world interceptor"
  []
  (fn [req]
    (ring-resp/response (str "Hello, " (-> req :path-params :name)))))

(defn insulter
  "Constructor for a insulting interceptor"
  []
  {:leave (fn [ctx]
            (update-in ctx [:response :body] str/replace "Luke"
              "optimistic fool"))})

(defrecord StatusHandler [data-source]
  i/IntoInterceptor
  (-interceptor [this]
    (println "getting interceptor...")
    (i/interceptor
      (fn [req]
        (println "inside handler")
        (ring-resp/response (str "Current state: " @(:state data-source)))))))