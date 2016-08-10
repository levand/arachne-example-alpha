(require '[arachne.core.dsl :as core])
(require '[arachne.http.dsl :as http])
(require '[arachne.pedestal.dsl :as ped])

(core/runtime :arachne.example.alpha/runtime [:arachne.example.alpha/server])

(core/component :arachne.example.alpha/hello-world {}
  'arachne.example.alpha.web/hello-world-handler)

(http/server :arachne.example.alpha/server 8080

  (http/endpoint :get "/hello/:name" :arachne.example.alpha/hello-world)

  (ped/interceptor "/hello"
    (core/component :arachne.example.alpha/insulter {}
      'arachne.example.alpha.web/insulter))

  )





