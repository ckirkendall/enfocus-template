(ns leiningen.new.enfocus-template
    (:require [clojure.java.io :as io])
    (:use leiningen.new.templates))

(def render (renderer "enfocus_template"))

(defn enfocus-template
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)}]
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["resources/public/css/bootstrap.css" (render "bootstrap.css" data)]
             ["resources/public/img/glyphicons-halflings.png" (render "glyphicons-halflings.png" data)]
             ["resources/public/img/glyphicons-halflings-white.png" (render "glyphicons-halflings-white.png" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ["resources/public/templates/welcome.html" (render "welcome.html" data)]
             ["src/{{sanitized}}/client.cljs" (render "client.cljs" data)]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             )))
