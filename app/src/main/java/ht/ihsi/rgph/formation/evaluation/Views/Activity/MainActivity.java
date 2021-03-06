package ht.ihsi.rgph.formation.evaluation.Views.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ht.ihsi.rgph.formation.evaluation.BuildConfig;
import ht.ihsi.rgph.formation.evaluation.Constant.Constant;
import ht.ihsi.rgph.formation.evaluation.Models.PersonnelModel;
import ht.ihsi.rgph.formation.evaluation.R;
import ht.ihsi.rgph.formation.evaluation.Utilities.Shared_Preferences;
import ht.ihsi.rgph.formation.evaluation.Utilities.Tools;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    //region [ ATTRIBUTS ]
    public TextView tv_message;
    public TextView tv_Utilisateur;
    public TextView tv_GestionCompteUtilisateur;

    public Button btn_QuitterApplication, btn_FomulaireExercicesListe, btn_GestionCompteUtilisateur, btn_Connexion, btn_Resultat;

    public LinearLayout LL_Fomulaire_MAIN;
    public LinearLayout LL_FomulaireSDE;
    public TextView tv_CopyRight, tv_titre;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            if(savedInstanceState==null) {
                startActivity(new Intent(this, SplashScreen.class));
            }

            infoUser = Tools.SharedPreferences(this);
            if (infoUser != null && infoUser.getProfileId() != null) {
                profilId = infoUser.getProfileId();
                nomUtilisateur = infoUser.getNomUtilisateur();
            }
            // Toolbar creation
            //toolbar = (Toolbar) findViewById(R.id.toolbar);
            //toolbar.setTitle(Html.fromHtml("<b>" + getString(R.string.app_name) + "</b>"));
            //setSupportActionBar(toolbar);
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            tv_CopyRight = (TextView)this.findViewById(R.id.tv_CopyRight);
            tv_CopyRight.setText(getString(R.string.msg_Developpeur) + "  -|- Ver. " + BuildConfig.VERSION_NAME);

            tv_titre = (TextView)this.findViewById(R.id.tv_titre);
            tv_titre.setText(getString(R.string.app_name) + "\nVer." + BuildConfig.VERSION_NAME);


            tv_Utilisateur = (TextView)this.findViewById(R.id.tv_Utilisateur);

            tv_message = (TextView)this.findViewById(R.id.tv_message);
            tv_message.setVisibility(View.GONE);

            btn_QuitterApplication = (Button)this.findViewById(R.id.btn_QuitterApplication);
            btn_QuitterApplication.setOnClickListener(this);

            btn_FomulaireExercicesListe = (Button)this.findViewById(R.id.btn_FomulaireExercicesListe);
            btn_FomulaireExercicesListe.setOnClickListener(this);

            btn_Connexion = (Button)this.findViewById(R.id.btn_Connexion);
            btn_Connexion.setOnClickListener(this);

            btn_Resultat = (Button)this.findViewById(R.id.btn_Resultat);
            btn_Resultat.setOnClickListener(this);

            tv_GestionCompteUtilisateur = (TextView)this.findViewById(R.id.tv_GestionCompteUtilisateur);
            btn_GestionCompteUtilisateur = (Button)this.findViewById(R.id.btn_GestionCompteUtilisateur);
            btn_GestionCompteUtilisateur.setOnClickListener(this);

            LL_Fomulaire_MAIN = (LinearLayout)this.findViewById(R.id.LL_Fomulaire_MAIN);
            LL_FomulaireSDE = (LinearLayout)this.findViewById(R.id.LL_FomulaireSDE);

            init(Constant.FORM_DATA_MANAGER);
            init(Constant.QUERY_RECORD_MANAGER);

            CheckPrefIsUseConnected(false);
        }catch (Exception ex) {
            Tools.LogCat(this, ex);
        }
    }

    //region [  ]
    @Override
    protected void onResume() {
        //Tools.LogCat("W", "onResume");
        CheckPrivilegeUser();
        super.onResume();
    }

    public void CheckPrefIsUseConnected(boolean forConnexion) {
        try {
            Shared_Preferences SPref = Tools.SharedPreferences(this);
            Boolean checkPrefIsUseConnected =  Tools.CheckPrefIsUseConnected(this);
            if(!checkPrefIsUseConnected){
                cancel=true;
                btn_Connexion.setVisibility(View.VISIBLE);
                LL_Fomulaire_MAIN.setVisibility(View.GONE);
                btn_QuitterApplication.setText(getString(R.string.label_Quitter));
                if(forConnexion) {
                    intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
            }else {
                cancel=false;
                btn_QuitterApplication.setText(getString(R.string.label_Deconnecter));
                btn_Connexion.setVisibility(View.GONE);
                LL_Fomulaire_MAIN.setVisibility(View.VISIBLE);
                //CheckPrivilegeUser();
                message = "Bienvenue: " + SPref.getPrenom() + " " + SPref.getNom();
                tv_Utilisateur.setText(message);
            }

            if(SPref != null ) {

            }
        }catch (Exception ex) {
            message = "Erreur :";
            Tools.LogCat("Exception: CheckPrefIsUseConnected :", ex);
            Tools.AlertDialogMsg(this, message +"\n"+ ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        try {
            Shared_Preferences SPref = Tools.SharedPreferences(this);
            switch (v.getId()) {
                case R.id.btn_FomulaireExercicesListe:
                    CheckPrefIsUseConnected(true);
                    if (!cancel) {
                        intent = new Intent(this, DisplayListActivity.class);
                        intent.putExtra(Constant.PARAM_ACTION_BAR_TITLE, ""+getString(R.string.label_TypeExercices));
                        intent.putExtra(Constant.PARAM_GRAND_TITRE_HEADER_ONE, "");
                        intent.putExtra(Constant.PARAM_SOUS_TITRE_HEADER_TWO, "");
                        intent.putExtra(Constant.PARAM_TYPE_FORMULAIRE, "" + Constant.LIST_TYPE_EXERCICE);
                        intent.putExtra(Constant.PARAM_MODULE_STATUT, "" );
                        intent.putExtra(Constant.PARAM_ID, "" );
                        startActivity(intent);
                    }
                    break;
                case R.id.btn_Connexion:
                    CheckPrefIsUseConnected(true);
                    break;
                case R.id.btn_GestionCompteUtilisateur:
                    // On affiche la liste des
                    showListView("Liste Compte Utilisateur", Constant.LIST_COMPTE_UTILISATEUR, 0, 0);
                    break;
                case R.id.btn_Resultat:
                    // On affiche la liste des
                    showListView("Liste Compte Utilisateur", Constant.LIST_RESULTAT_EXERCICE, 0, 0);
                    break;
                case R.id.btn_QuitterApplication:
                    Disconnected();
                    //finish();
                    break;
                default:
            }
        } catch (Exception ex) {
            Tools.LogCat("Exception-onClick(): getMessage: ", ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    //endregion

    //region [ METHODES UTILES ]
    private void Disconnected() {
        PersonnelModel personnelModel = new PersonnelModel();
        personnelModel.setIsConnected(false);
        Tools.StoreInfoPresonnel_PreferenceManager(MainActivity.this, personnelModel);
        CheckPrivilegeUser();
    }

    public void showListView(String actionBarTitle, int typeFormulaire, int statut, long idMere) {
        intent = new Intent(this, DisplayListActivity.class);
        intent.putExtra(Constant.PARAM_ACTION_BAR_TITLE, actionBarTitle);
        intent.putExtra(Constant.PARAM_TYPE_FORMULAIRE, "" + typeFormulaire);
        intent.putExtra(Constant.PARAM_GRAND_TITRE_HEADER_ONE, "" + actionBarTitle);
        intent.putExtra(Constant.PARAM_SOUS_TITRE_HEADER_TWO, "");// + txtHeaderTwo.getText());
        intent.putExtra(Constant.PARAM_MODULE_STATUT, "" + statut);
        intent.putExtra(Constant.PARAM_ID, "" + idMere);
        startActivity(intent);
    }

    /*public void showListView(String title, int listType, int typeformulaire, long idMere){
        intent= new Intent(this, DisplayListActivity.class);
        intent.putExtra(Constant.PARAM_ACTION_BAR_TITLE, title);
        intent.putExtra(Constant.PARAM_LIST_TYPE, ""+listType);
        intent.putExtra(Constant.PARAM_TYPE_FORMULAIRE, ""+typeformulaire);
        intent.putExtra(Constant.PARAM_ID, ""+idMere);
        startActivity(intent);
    }*/
    //endregion

    //region CONFIGURATION
    private void CheckPrivilegeUser() {
        try {
            message = "";
            SetVisibleControls(View.GONE);
            Shared_Preferences SPref = Tools.SharedPreferences(this);
            // On verifie si l'appareil est configure par l'ASTIC ou le superviseur
            tv_GestionCompteUtilisateur.setVisibility(View.GONE);
            btn_GestionCompteUtilisateur.setVisibility(View.GONE);
            btn_Resultat.setVisibility(View.GONE);

            if (SPref.getIsConnected()) {
                btn_Connexion.setVisibility(View.GONE);
                LL_Fomulaire_MAIN.setVisibility(View.VISIBLE);

                SetVisibleControls(View.VISIBLE);
                //tv_GestionCompteUtilisateur.setVisibility(View.VISIBLE);
                //btn_GestionCompteUtilisateur.setVisibility(View.VISIBLE);

                if (SPref.getProfileId() != null && Constant.PRIVILEGE_DEVELOPPEUR == SPref.getProfileId()) {
                    tv_GestionCompteUtilisateur.setVisibility(View.VISIBLE);
                    btn_GestionCompteUtilisateur.setVisibility(View.VISIBLE);
                    btn_Resultat.setVisibility(View.VISIBLE);

                }else if (SPref.getProfileId() != null && Constant.PRIVILEGE_SUPERVISEUR == SPref.getProfileId()) {
                    SetVisibleControls(View.VISIBLE);
                    btn_Resultat.setVisibility(View.VISIBLE);

                }/* else if (SPref.getProfileId() != null && Constant.PRIVILEGE_AGENT == SPref.getProfileId()) {

                }*/
                tv_Utilisateur.setVisibility(View.VISIBLE);
                message = "Bienvenue: " + SPref.getPrenom() + " " + SPref.getNom();
                tv_Utilisateur.setText(message);
            } else {
                btn_Connexion.setVisibility(View.VISIBLE);
                LL_Fomulaire_MAIN.setVisibility(View.GONE);
                tv_Utilisateur.setVisibility(View.GONE);
            }


        } catch (Exception ex) {
            Tools.LogCat("Exception-CheckPrivilegeUser(): getMessage: ", ex);
            ex.printStackTrace();
        }
    }

    private void SetVisibleControls(int visible) {
        btn_FomulaireExercicesListe.setVisibility(visible);
        LL_FomulaireSDE.setVisibility(visible);
    }

    //endregion
}
