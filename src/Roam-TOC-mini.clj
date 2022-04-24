(ns my-custom-roam-18042022
  (:require
   [reagent.core :as r]
   [roam.block :as block]
   [roam.datascript :as rd]))

;; Pozor: {{roam/render}} blok pro generování TOC při každém novém generování (po kliknutí) smaže své children (podbloky), takže ručně do něj nic nevkládejte (neindentujte)


(defn get-page-headings [block-uid]
  "Vrací vektor se všemi bloky první úrovně na stránce, které jsou typu H1, H2 či H3"
     (mapv #(rest %) 
           (sort (mapv (fn [heading] 
                         [(first heading) (second heading) (last heading)])  
                 (rd/q '[:find ?order ?uid ?heading
                  :in $ ?block-uid
                  :where  
                     [?block :block/uid ?block-uid]
                     [?block :block/parents ?page]
                     [?page :block/children ?children]
                     [?children :block/heading ?heading]
                     [?children :block/uid ?uid]
                     [?children :block/order ?order]] block-uid )))))

(defn create-TOC-rows [where headings]
  (mapv #(block/create {:location {:parent-uid where
                                  :order "last"}
                       :block {:string (str "((" (str (first %)) "))")
                               :heading (second %)}}) 
         headings))

(defn delete-children [block]
  (mapv (fn [uide] (block/delete {:block {:uid (first uide)}})) 
       (rd/q '[:find  ?uide
          :in $ ?block
          :where  
             [?a :block/uid ?block] 
             [?a :block/children ?b]
             [?b :block/uid ?uid]
             [(str ?uid) ?uide]
             ] block)))

(defn create-TOC-btn [block-uid]
    [:span
     {:draggable false
      :style    {:border "2px solid #FFC107"
                 :cursor "pointer"
                 :border-radius "6px"
                 :background-color "#CE841866"
                 :border-bottom "solid 2px"
                 :border-right "solid 2px"
                 :padding "2px"}
      :on-click (fn [evt] 
                  (do (delete-children block-uid)
                      (create-TOC-rows block-uid (get-page-headings block-uid))))} " TOC "])

(defn main [{:keys [block-uid]} & args]
  (create-TOC-btn block-uid)
)
