(ns arachne.example.alpha.web
  (:require [ring.util.response :as ring-resp]
            [clojure.string :as str]
            [arachne.http :as http]))

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
  http/Handler
  (handle [_ req]
    (ring-resp/response (str "Current state: " @(:state data-source)))))