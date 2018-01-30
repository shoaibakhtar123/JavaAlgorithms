package newprogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindSubStrings_Working_InCodeFight {
    public static void main(String[] args) {
        FindSubStrings_Working_InCodeFight findSubStrings = new FindSubStrings_Working_InCodeFight();
//        String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
        String[] words = {"nuclei"};
//        String[] parts = {"a", "mel", "lon", "el", "An"};
//        String[] parts = {"aaaaa", "Aaaa", "E",  "z",  "Zzzzz",  "a",  "mel",  "lon",  "el",  "An",  "ise",  "d",  "g",  "wnoVV", "i",  "IUMc",  "P",  "KQ",  "QfRz",  "Xyj",  "yiHS"};
//        String[] parts = {"WjN","gr","zWo","qVRJI","oGtu","Rtae","weY","vtJVN","UpvGj","pkB","iTtP","pbW","yvSlm","ryCd","eDCM","fjpDW","gbb","OF","vdz","x","NPS","kuU","irU","qkEn","aDpIy","oOZYR","PG","plTjl","zmpP","C","ZO","vwQKC","K","S","jod","W","gYOTF","ObN","WWW","Zj","k","dYKay","sZpnz","uZpG","w","vKELP","UD","PdD","GeS","SpkW","BKb","VjVF","DbKWv","mHSo","zyUPs","fzE","DHT","JiVx","fDI","xC","JFEU","KJdW","pYf","ajIIy","B","J","N","VwM","V","mIzeb","QMDe","ycVQU","uw","j","bpzvj","mv","z","Ct","nJ","Yoj","in","YQ","UfSS","Dn","IxDg","ryfh","KjaGa","Xfz","FVXL","QCk","RyAJ","vIEM","pnnRC","Qj","egG","a","e","i","incPb","Ucy"};

        String[] parts = {"PdtYF","OkP","KYh","gQWt","yrMsJ","JmxgC","Pcq","cVYd","qha","zpi","MZvcq","dsWjJ","TINb","DLnY","EwJz","gAdUk","Osdd","tDwf","wdZFX","slG","Kqwu","tX","QrW","nwS","aui","OJLF","XBq","zEp","PcT","WrI","bXH","xbU","fXRv","UBqa","EAcbV","EwAuV","cGmrl","tT","KjDjU","wLWNd","HhS","GV","GU","AnPCT","rOL","qaXh","Xiss","taOWp","IbZPE","mUHt","WtAy","MobAD","fiFnJ","NHNHZ","GD","upZ","GB","Ynz","jCm","GM","vbqZE","IXT","GH","EJN","MAP","tAKq","GSH","Gq","cXRQT","SNO","uqcX","JKji","Gx","JNeK","Ge","qjyZr","OfCV","Drdi","Go","gTVb","etBNZ","MGUg","Gj","Gi","XVfp","oPCrn","CgeK","EVK","SIB","KhrXm","Ohwem","Cg","bsmnG","jfik","HAruq","kUxeg","MlhDC","KHPFM","RQ","SBFBo","LMoX","lwEVE","cVka","DlKi","cZRlO","TTU","tC","ApR","IysIS","bIzs","AAhG","PzpOr","TONk","FgR","ZM","ZN","ZO","ZH","ZI","NXTD","UoR","RaETq","NShA","ZG","mjVHy","JRFFk","ZC","UvH","yrYE","ZY","ZZ","CUr","BYqFZ","VnKHp","ZW","sylMb","fCAib","ZR","gBlz","Zl","Zm","pQMJG","Zo","Zh","Zi","NOJ","Zd","k","qOvUp","Za","HrWx","Zc","pMd","DiyCt","nacZB","sKvp","Zz","nASbp","koJ","Zu","Uvc","Zp","Zq","Zr","zMuDu","gkVCq","zQtbE","cemUj","bngU","gEJY","MFHlN","rPBsA","VBM","FUYx","ZKhc","lwN","mAD","neIQ","yKIHD","oiBW","irVhr","PDIOz","mAM","IHYn","nYZ","lIrK","wgRy","Tfn","JeV","txH","APAin","ej","vSy","ltN","gblO","lwk","zckeO","OZIs","aXeJS","KUkW","TqQXS","bSom","JeI","is","ptZ","mE","mD","mF","xhF","FEJpP","mB","biRq","yo","mN","mI","jGnE","PkZt","yCi","NZNM","qds","KuHN","V","iAHn","yurX","McsCe","mY","mX","SWrr","WOx","mg","haxQx","mc","FxFno","YMaqW","LMU","zDzf","Cz","mu","yyau","uWbpj","oWj","TfRXY","erm","JUhko","SvNR","my","rpGkg","ONj","GgT","IIw","Le","qikO","EHtha","UKY","GgR","qHZ","qHX","sKb","rkhBT","vwDwU","Lh","Li","Lv","Lw","JsW","Ls","jAQV","Lq","Abx","gRr","UdrRC","Lz","Lx","ONu","vtkO","wIe","LE","mjwkQ","LO","LL","svSZn","WkFWp","SFr","lI","LV","LW","tJr","LR","LS","FxEC","GDDzu","vCMt","if","LZ","TtdM","HedC","LY","A","BbP","uqNK","bLs","iX","WXKAs","Ek","NTUgw","uhHBD","qzlBb","HPI","Bzf","KsOZ","NsYSd","EGERs","pTn","nYAu","jeCi","OFAjy","ZHht","XjdaP","fEG","iIw","RZo","fEO","kvneD","BzG","cHQ","yqy","Chimj","iIl","SBWL","vjd","ECw","DJD","PrOBN","iaM","zhbV","rWnG","Iyku","mOCUG","IevAx","oRM","PiTdz","zet","lDR","MEVL","TzqnJ","xlGYB","GRlrS","cZQyc","JOP","HQNK","FXJZ","Yzn","jnyz","Rbvqn","QRQ","vNPw","xm","IbGn","YGhP","OPbMb","rLx","gFP","MwrYf","UaqG","hAE","dWw","mxx","yNUu","SLup","eYpE","tTV","JAQ","Izfs","VtPF","UYg","NNBOR","lUlC","pjq","kgmiF","maCy","KJaF","Xh","DJw",
                "AOZT","QLEfD","Fo","l","lnWQ","UtpIV","RBWZD","UaDDl","wPRJ","smcF","aDBi","JAc","bBMmP","EKkGS","rU","pnHP","rQ","uiUk","YSB","Rbcjk","rY","uKq","MJi","rE","qaWU","rG","rA","xs","pkhIZ","pNC","YSP","ugkP","rJ","pfjpb","Gg","CBFWA","rw","Uuy","rq","NLY","ckHD","HhXw","rx","rz","rd","VH","rf","Kegk","rb","adv","ATF","rn","dTt","rh","ZVqYn","mdT","mvP","UGRi","XCf","AIZAg","oXDQc","KXo","OW","Egq","LfoUx","dAH","EuO","opOfa","wgJo","zfzM","xuE","rDTIR","xjzbd","atR","AFY","W","Gn","cbCF","AVTJ","Pdb","TvYPT","xO","vlWS","BOcwI","PHNT","KtUY","VQ","ykcD","VR","FmaVm","HQMcI","GbvL","XCP","TNl","PdJ","rHp","Qydkr","GflVd","UVeW","bYC","OGZg","xmwS","seYC","gdqDC","NrI","qlkBF","lKtaL","oOvBu","zozh","AhEB","LSd","KkWNj","VX","lD","LNk","VrJR","xE","oBtS","RMS","AWqGG","PINp","qkO","SbT","bVmB","ybFz","OdgIu","dCUpA","ddmu","SaJm","qhHe","Fzql","TbaC","SiLmy","OcDSv","bEQ","Cey","jeD","YOo","eCE","B","gyb","RsaH","fRxPl","ktT","mSs","IzhWm","gyk","YgEI","fwKp","fRoFV","YqpK","lUg","EyYL","PvI","BBV","EUl","UyXx","oC","ew","YO","DHFtG","YAw","epy","suU","geCqR","bi","NckNn","tnBaf","dIju","vCW","gxBST","RpUk","DMwc","Tqe","Vk","oqs","Ouot","Kb","xsjKc","BLeXw","fJa","xqgW","RGE","YwJRp","TKRo","rBHW","iHJ","Izq","VcX","ggAOx","CGbRB","CYf","DrFf","oql","cqAn","Hdr","fJI","ZrCJl","tPdrb","FxthN","MxMyP","zFU","jfLMQ","beB","UrIjC","QaA","cKP","lJMXv","ASckz","hjyQ","jxh","ENwof","VFax","jxl","BcNY","Qq","Qp","Qs","LGnZ","PaDBt","EevCQ","lN","Qv","Qy","Qx","Qz","omage","rR","CYunk","Qa","y","Qc","tLUCR","Qe","Qg","qyj","Qi","VCY","tyv","uXbsH","ItR","Mbv","HBy","YkAyk","QP","sAi","QR","QT","bgeWr","QV","pRm","QX","lpu","vcgO","m","zIMlg","yand","QC","ftGCb","lOcUH","WLeD","RKwUM","QH","GwNF","yDekC","QL","cYm","kagD","zLe","BhJyl","IiGt","ozeXH","Kkif","IHEy","wzT","gBm","ZFW","TTV","PHxY","QgbLW","TMqiz","PTOWj","hrK","egavE","qcrKZ","XpZOW","BOHzW","Ky","SIdfu","Cbtms","fMSs","HaRZu","UOJo","pPDuI","Uidzt","ASCw","lFgAH","abr","Bia","Ylji","hR","tyzhr","ZFn","PAf","CDNH","odar","riA","RVcSp","YedD","leiy","iAlrY","do","dl","PdoVK","dj","dk","OZtq","GlFb","UKYCG","dg","HYoJ","de","dc","tKH","nYySP","uLoV","KMDQg","kvyU","dz","SzXtF","dy","qOO","X","hHpk","dp","Loug","dN","dOsZX","YyLo","bap","kJE","dF","bwmw","OIE","sKZk","dB","dC","bax","dA","yfU","Gfh","NGUEo","ZEQ","yfQ","dX","dY","rVPJS","dU","dS","HdvW","GFcxg","GJzhQ","ArZxe","Dmwr","mSGUb","KrVK","NJYzx","nTAx","nATI","Efl","NIiQ","MPKsy","dw","AFzOl","iOq","QRjC","cOnO","BUZ","QGdMY","dkuym","INGmm","Vno","Ufb",
                "GBj","GBk","oX","GsDqS","XDV","RRYi","DMs","mRM","tUeDF","eIk","eTI","AEo","C","BnzI","wc","XRK","JLr","wm","JLy","wi","wZJg","wu","wt","wp","rMJ","UBk","KKr","aJB","UeJKP","wx","FtHK","wD","wC","wB","zbA","FXOXc","AsfO","wtZ","xDl","Hjy","wJ","wI","wH","wW","wU","Tnuy","wQ","wP","wtI","Xvnyp","zsk","JfSuB","Kp","TWfP","jRuj","Vca","CrImB","gxo","UbmfQ","BCA","pLGLU","fUJh","XsMc","oaGY","Fxsls","sdmts","DJ","pAR","XbrE","wqHnt","IsNO","VfwIf","wFmNm","gLoXV","sSul","gxV","IqNg","HskZQ","SSN","ZS","HUb","IsKRd","CJ","BxmME","CH","gnW","WsJz","yxKll","WIQAW","pOT","Zn","CE","CD","CY","CX","jeWkz","QNb","CS","CR","wfQ","YRpi","CV","PMYQ","uNAz","tG","Cn","AUduv","Cl","Auju","UtN","wjdr","Ce","n","wfz","VDXaI","Cy","Cx","Cr","DMhGL","IvaOI","Zf","iz","CUVAT","azAYO","nIxP","uRTRH","XyFfD","ir","iu","wYz","pegKb","iv","nKtq","UsTZC","im","CVK","io","in","XOTIA","ib","YFUn","ig","HQNd","iY","bBdzB","vAQN","NXg","iQ","iU","Pam","iI","iH","iK","iJ","sDOsK","iO","SIvA","dJpU","iSzBp","Ikh","iD","iG","UqbJ","Cksz","VB","VD","gdiiv","VG","ceNr","VK","VM","VN","czGrq","xVgQI","mQP","xjW","epM","VT","jki","XHWx","Y","BEYm","CgAxU","AQYsc","ixGrh","YdZzf","MVnl","xje","Ve","qoiu","Vg","FMBYa","Vi","KcOY","gKqN","Vm","yAR","Vp","Df","Cdv","Vt","drg","Vv","xiRjy","iSSCW","fJXJt","GIbxv","wfgiS","MlQT","RVb","KcC","tDC","gPUa","FUINE","EHMZa","IUZf","stpIW","erwDp","Lxrco","DRC","ZTYn","pUXwF","NNU","mYaqd","kRa","KGFba","FTErI","wKCt","KKil","kMH","kzaE","ZDkld","ThpY","onRN","Wqmzt","cJg","diH","OZEe","joGyh","D","toBS","gBSo","tHyxj","Dy","bpc","NUbP","bbT","CXa","iOM","CXc","CXd","LyB","ZmSq","jyK","fVpC","WgBV","CKpD","cDveB","Arv","pArV","TJihv","JIYcN","MdPCv","pZDjG","GYZ","hpook","gROr","zGK","Arh","dBZzd","jgjM","rI","umT","HX","HDAx","isdWz","Mluq","EyRhg","cuLbp","xHN","EOqZ","rJgS","mkKf","HACL","Ewz","blNm","uQN","HN","olu","QfsIU","oVNgp","nKG","HG","MGvlP","jyf","Hx","eYZL","fos","FCl","Hq","Hv","GSpO","vdBZ","Hu","Hj","CPaH","idJte","Hkn","Ho","iMhl","fKOI","ElfQ","PTV","yxdh","mHYg","fYC","COmAu","llApQ","nBof","hTyEZ","TbHx","xlzvr","EyLfX","nYX","iskP","OCmk","ZVDB","BHCMu","UWh","ZdgJG","QOsHG","ETlGl","jaeh","AD","xsKaG","UZAR","yqju","Llc","qVba","hE","CJn","AVY","RdR","GsY","xaIjx","MPL","MRXTm","GoPR","vGyk","o","akQp","ZGh","qzYAB","akbRE","nQkPA","KLwnG","iOBg","PBo","NowW","JAZl","ixZrd","rqRp","jLS","AeQl","Fen","Usn","NBp","AVkuS","FkZz","Usw","XbC","Lke","ZoGk","kWLy","wCmZH","ejF","nmdPq","LzBEB","ODTzP","WgWV","mvVqZ","SUa","Gmzjr","YQe","qPV",
                "vSz","GsZtM","ls","KgSkR","JMr","YVwfe","hszf","bsrsM","eeIH","EDDR","TYRln","Btbc","GQ","HP","HBsgH","eVhF","frgu","bFYj","GOl","inVD","pfJqR","ocFn","HW","JiOPl","jKmTT","sfZ","Z","azT","BSTA","OJqga","dcwj","HJ","NwQsD","ybUU","kmcR","UcfLZ","Mxvy","KhRt","LVpG","QPmz","sIgw","HMqW","hpyY","gfln","nH","eOb","nJ","Mqxo","Sz","SyMj","SJQ","oYYNq","nD","okMP","GWbYT","Mzlz","Sic","nZ","zQcga","khm","hNy","nR","nS","nT","nU","EJfa","cYsTm","eecjr","aCx","kBvx","nm","ttanM","RUWwK","nb","yiEf","uWw","ive","taXT","WTNC","mM","nz","CES","bklza","BZUzY","IJJxH","nr","ns","wL","FHpiv","ZCuL","nw","MdA","E","MLt","IVTU","UGHRY","LEPcI","kEJzs","Idq","XoOz","xMvl","nvUqf","UNJr","swXh","ihOw","oHS","uMpv","AdlZT","MrPj","Stu","mW","KLk","uztqv","IW","ZGfNP","qSjRw","Hs","sqE","wY","aVGO","moUG","AqP","BUryJ","Ps","OYV","fMPEI","mR","mKiVZ","YECer","veF","mAid","OqIA","TryZz","sUKAx","iNE","ror","uxpxO","TDoQU","lle","EZMq","ahRx","zxtK","SNcmP","bDy","TZv","QgS","Hkh","lQPvD","czxt","Ui","gRO","sJmIb","WJXb","CXLf","auSkp","llE","XpT","pCreH","TaP","aFvGh","ngPK","TXqX","HzHB","VoFH","DGveu","Hb","JQXxb","nunyP","VBKC","qox","qWBr","vpP","QQE","mAaFy","RPNPK","cjvB","BtNk","QQO","nkG","WU","yFLNf","p","yEFze","CHgS","wXI","tWb","zrU","SP","pmp","VzD","EvpZi","gLo","VjPvg","Inp","YBXs","QyWO","mCOU","tWw","Cqloz","URJiv","GoQd","sYOv","Ip","axVvO","fIqE","fxFi","vFklq","lTKfg","PCq","Mu","iPHq","vfpGs","tWP","jlJA","GrC","fKxr","EKjN","OdaP","iMAuN","ShEX","ekO","HkRE","zmFzD","uFsi","Mc","Mm","Ml","Mn","nBV","Mk","BozJ","hrwo","sGa","ncYg","Mv","Mq","O","Mr","LX","xTm","aUz","tET","BKQxV","ME","MG","fmaS","PkTBF","MC","MB","MM","jdq","qUOsC","TDTQA","kaaVW","MK","MJ","MU","Wo","MW","VxGL","Tysjk","MP","OKI","nBb","vw","fTqs","MPs","fbr","tGSi","Lg","PFwkp","qhZAE","xHh","hyEgX","QthhV","AwBQ","fbb","msK","zzf","OgE","Hgpg","OgF","GLT","or","pHgo","re","dUtP","Rsa","by","DOx","BVTPB","qTwZE","msg","msf","msd","HBOxH","XJt","CYZD","IVH","AeVi","QBgY","FuLUI","OQlSR","F","dSr","byQi","JJt","bF","Evf","MMr","giCR","flM","QCUE","efnT","DIbwq","DSwa","Evt","HlB","flG","qTOU","Poyvk","ZJkP","TOjxE","SBT","Oul","MnXUz","judg","AUl","rHWDB","KaBm","ulh","tJR","aAAz","fOjiI","wvB","SBK","gkQUs","SVRaO","JIAK","Mil","YuwsZ","AHGZ","FTOUE","pxRv","SAvS","hsO","jmymN","eulNl","DzGal","bAXW","tZauW","yQz","Miq","jftXE","PyD","jFaE","BIvpx","DJVh","KOk","kwSwJ","VPS","ERs","kyHiB","qV","yzBe","kyD","cTWP","Whr","uGB","cGUHC","Pyf","ZmonN","Fji","ADMG","MlfT","Ctr","cBbHi","sR","QGy",
                "sW","sV","sT","sK","aduLP","sI","dyBCz","yJMlO","sM","EdU","Ctl","DYX","pqz","WimQ","ftZA","dTk","sz","sy","cnFIn","HIhq","ijWRZ","dNC","sr","YvKCK","KZor","sv","su","lGgqI","q","NCJ","so","sn","sm","sc","sg","tJk","vPk","TFR","hQx","YPgf","RyKMz","gtC","Rq","yGO","dTkWV","INx","cZQ","FoUo","tkty","ymmv","HcOL","bODvg","Zib","gnHJS","ZnVUw","PFuaq","Rm","Rn","RARz","Ri","cZE","RT","ChA","oWIQk","qJ","jDrt","pUi","VFi","iRMW","Tbp","VovF","xyw","REZN","lsK","RZ","rMhBQ","huI","LU","hhVB","bIegm","tbWqQ","oMsT","RL","FUAlL","RN","Zsxrc","ttG","RI","RJ","VqajA","Dpt","jaMTm","hOc","HJT","jbKU","oyh","kIUJQ","Yji","wAeU","Pua","lfa","ViPts","kDib","kkj","UWUX","gVcAD","bqMB","qt","qHi","WeuMw","qw","VCO","ugPUU","IvpH","noC","wF","vCYT","YvYz","WvqlL","peq","ZD","cett","eo","TEMu","ei","Gcd","bgpR","wUT","ed","eg","RTn","iSw","qayD","Dlm","SmlwP","rDOM","Doi","HBFr","uBM","kOoS","UDDer","TWHE","ev","laTPz","ep","er","eO","eI","Lpy","WFb","eD","wK","eF","bjLa","YQOnr","KcPr","ZiWV","eX","fIUa","eU","eT","qnE","BwwT","BwwV","wwx","xvqh","ayDQ","CwTK","G","rle","UFbh","mwqj","UPUB","IqhW","lYTL","RFK","oXnEC","eyKoC","PIyi","RFN","wfsbf","bbmw","TlQ","pONY","Vwnr","fw","tUcK","tQKh","sgZ","UmbR","WCiY","vjv","BFXRz","TlG","vPdR","ydYWM","wyBc","VjGm","NsnWR","CxlD","CAiNl","Lpj","xj","SLbRk","xXvtU","YOW","xo","vyHzP","WNc","WlKWX","xc","NDCcg","xf","AcfT","xd","kAL","IEvkX","xx","xy","KdHEa","ATP","eqduq","GcsiS","Pv","ISA","xq","xv","xw","iaS","FeVjC","xK","sRWDU","XUw","NyaJ","XtIq","xB","Lpc","DHZoW","Lga","fmr","zaC","psbak","nyhx","xZ","BWHFQ","ofBpp","fmf","xS","xP","xV","xU","twU","OTGJm","RunHq","wGMjB","qhiMM","HASD","CiVNH","wGo","TBdBA","rqQgi","rzI","UurP","hCZT","ayZ","CLY","FakK","BtO","RQVN","aJe","UVAt","iLv","nVWv","oNzjx","XRk","FRh","Ocoab","oNmF","sFUs","NxNAO","r","cRut","gOW","LafB","CvuI","DN","ane","DL","DM","eIPf","DK","DH","ug","DF","DG","NMQBE","DE","fZQs","DC","tAy","UCjLW","WM","DY","DV","DW","ZlzCZ","PhV","Eex","Dl","Dm","oPC","YWr","Dh","FBno","hlKI","Phb","De","Mfwv","fEou","Dx","njgFK","Dv","fD","jJe","ilNo","UDG","eQz","DWfg","ngeck","CbtS","XGd","ffHT","gMzP","Utc","OJKq","abFh","eQm","XHcx","RDZz","XGv","VcRnV","fSxI","TGyK","tiNR","NRK","WyV","jKWz","eowH","MUlDV","qPz","eha","wDjaX","YAHr","tRutH","Ucm","ynPs","wUnA","DZSw","WE","COiv","WC","lM","WKaoe","hbW","IDhgs","WJ","RkLZ","SnhS","GMlp","ySeGw","WS","bqLJ","CSpd","JTNo","gobMC","SkU","DqV","kesz","eIkxx","EwcC","yDVBT","jRXiX","ffdg","Wk","KiNk","Wh","QPVI","iKCiD","RIM",
                "klUF","Wq","Wp","WKXj","Wz","Wy","MSeHl","XhnE","XIB","VQy","Jcb","H","EwqE","CTxh","jpvRY","vGc","Psnc","clB","RqyX","geh","qIyny","iPWtx","EQy","yPQ","kpqmC","bSt","dPto","fd","hLeXg","nczi","Dcs","xYMM","FcO","Yenji","EQn","ssE","bSe","NEYG","bEmwI","FFYH","BELH","bAhK","JjGC","vxsLs","SieHh","rmx","EMI","hXVk","XIOi","blstD","lJOy","QJBFg","HIksc","jtE","wygY","ur","ytB","Cree","fNW","Ywte","VezK","hDyR","RGv","sbse","RGz","Tmypb","xeGcc","mopm","RGb","sNKsL","vFP","EXipo","ui","vcIPp","HnbOT","Zfq","rOVs","VCl","JpMR","goixf","TdDKM","wmqw","goCPM","jv","jw","oiJPk","jq","js","PdkWc","qmtN","jn","jh","ji","jj","jk","wZf","je","HtmqA","jg","Pmn","jc","zTL","aY","UlA","jX","Da","vARS","dtYt","FYQh","jV","pVz","xES","ibrB","jR","jS","jL","jM","s","jO","jH","GGkd","Kanv","jE","zTV","wtLE","jB","OantD","tQd","Jzm","DNzy","hvb","XdJ","aIr","JFtho","YbQeF","IwuKo","tsQD","FSU","HOMYP","plZf","yi","gNi","yxZMu","jf","xGIts","gNm","sDdOf","nilP","ZOVoS","eABYn","FfPI","EbRGF","evicW","ih","poO","JsjRI","AvQrx","QCZ","JzV","qAO","rQuZ","zTPK","RqpOg","hdT","mC","EpxoT","DaVMu","SnJ","LZiw","hdY","OQqRq","IImdN","cJdY","mP","WWQ","OEa","IAnHc","LkS","zAZ","nX","NPdpl","xroXP","jZ","qsD","KiGGe","kndym","OET","UPFU","BYZ","UGnd","QNaI","amqA","Dph","dnjc","mEoEB","yXuRR","MgX","URD","Gca","jcB","WWY","AiFrA","oiXIm","VwWcy","bSnwD","dLTmF","AxMa","Hpi","opR","pdRz","ZPVu","rGg","GACKi","TYLv","uxj","bwOj","uywRL","VIoMu","PCKt","mJOBC","Tb","xC","vvOWB","AIr","EIAHZ","Vra","lypMT","ZOMV","ldSho","PVubZ","SnnZ","EeeJ","CHJ","Jh","IX","mamYB","OfIz","I","IP","UjVXf","jK","eQRp","qJAW","hLdyx","IV","jD","IJ","rfiy","IN","EI","OrMn","Bcp","aEoN","PrBm","epeKL","Ix","GjqzA","xXp","lyR","LGe","fzfGU","Iq","rdet","Hzu","yMdaK","Iu","ZRYQB","Iw","NWxUB","kqoT","XlHo","iEXxl","Il","FmIyu","Ia","nXwaZ","Ic","Ie","Id","If","Zj","XYqZR","fvJ","tRIk","BmLj","iWJEC","NAN","pEq","exC","Zzr","PbZP","aL","NDLU","Gtnw","SfKQ","HsfnL","co","ZSI","fvS","nx","qqbj","TLRa","LYP","bPD","qHlU","Wg","aVJzb","SfQsb","nIM","JEoL","yWF","OKbF","Wjz","OqI","cb","gdK","XJy","bQbiL","zX","YVT","moz","fNfv","EbM","wfnF","BQH","FVfdD","zlU","aImL","NEIZ","xTjM","sXrB","xPBl","Wxki","kjtC","mob","PiR","MDSv","OuIZ","NCBp","yBqtX","tyZV","bTTNL","OUdJ","amE","YtEB","xZBYE","fSh","Ro","t","tAaPe","SGmcN","XdR","Qomga","jgL","ZlpLi","ve","CvjK","KsakD","gvG","UgBT","yD","Kuo","pRcz","AB","Zgl","cr","AE","eVd","kKqT","QBiTn","JuY","FyAHx","aLvR","LVXgI","kmj","JjOf","rnQNZ","Kaox","WVI","kBgz","nIT",
                "WVB","sDo","lSZBL","ZnUR","yKORf","KmMJ","nmv","WrJGl","oL","oJ","hcZZU","GcAe","aFZR","ysKG","xlypC","uT","WQWD","KxDmJ","oKZH","bekw","AZAoA","oW","oV","GlEvk","oT","OyJkB","RNYyf","qzlNz","XWzZW","NUoRH","om","ol","ok","cM","hAN","lenr","og","yU","od","sBNKk","zItU","ciKJ","hAX","PjCK","Ug","rPxI","nmB","oz","cqb","heJk","ov","ou","waXG","os","qbUFY","Oli","Nh","Ni","aZj","MbJKJ","loF","KgT","btZal","Adq","imcwq","Jc","Ipbg","TFX","Nd","Kixf","Vwze","Ng","Nx","qrt","JmO","qHBj","Maqan","kRpsZ","Nu","kQm","ifJDy","NH","zAY","xJeo","qUOH","nAF","NM","gkxD","NO","YdpWL","kyvOQ","AdZ","gLMY","NZ","wWWt","TU","DiiGM","ehn","tZtoh","aZS","NT","NU","VHJlK","NW","zhvcH","fOv","rHqEO","LulEl","J","xCED","epLU","nBafl","wgH","rjg","AvM","yz","SHt","NDVG","IXJi","LDL","OoOKn","Xsn","sTybm","rjh","zsyr","PnlwX","cP","Iidv","Qmqm","EPMyw","BCOn","rF","OCgkF","JDYi","yPYN","VNdAu","rZ","ZsXq","yKX","teCC","zzGgy","vRED","MPJhj","WdFj","AZL","ad","ai","ah","LsqR","fWg","am","al","ao","fsm","cbs","Zso","at","UFLg","OvE","IQE","az","CAiXt","PXd","AZh","HoG","aB","EPpg","sSeP","igq","iAle","aI","BkcB","aJ","Wj","OeYi","UlOI","TybHY","Ar","FgB","PXM","IQzuJ","rvY","aZ","fGV","Mqd","tRi","ZCf","eoHhQ","rdoMA","org","ZvWu","gpEV","rv","qONX","vgu","SCBPZ","Fbvx","hwx","cNcQ","YGDx","lGAA","fgHYc","zzei","rxi","YqL","tRK","lYq","FNFi","LyuE","lzkty","kWRdU","Biao","zqo","u","usFw","Dydv","YVk","gIL","KvfP","heFye","YUoUN","alo","SIQ","tZ","CJBs","yp","tY","tW","vJso","tU","tR","AeCmr","tQ","BcqF","MkOW","tM","tJ","FEC","sct","tD","pTpl","zmW","AHZh","JBIyP","czaqO","TAW","tz","ty","qXd","xoYRN","gp","joXEe","ts","tq","sgAE","to","tl","tj","jHT","th","ti","tg","te","gIWxK","oZy","kYIHd","COVI","OUsW","EciH","YsOV","npKWk","zbrA","bITbY","fE","JdoK","GMgG","vda","jNif","dQmOS","ozCa","uwb","WMWbs","DDbuK","Wt","ami","BRZPE","rtqf","mdTpl","SwWt","NyAza","dFEhs","Vsb","dDPO","pJPG","wjqe","FwhPr","VFKRD","UNu","DJn","iDNbv","grzJ","ten","KaENA","hNJt","GUJ","bJkE","KBe","TOk","iMcR","NtJ","mhBcW","UbUl","CBkL","eUbxH","udRt","cgCe","ngCg","UFX","hVvZm","RYU","LiHvP","KBO","JtEBz","nRuuU","BTr","eKC","abm","QGq","wvpgl","FMII","JMtQ","tUGSc","nvegM","iV","abv","AhLT","Xrkq","NFF","AYdkx","MCMMJ","LDrPq","PdlYv","K","XZBQi","FLHhR","ubvFZ","TmcV","gT","BLG","hwhZn","MAtXF","CrhYm","DEc","byu","Flxw","iAUV","Xvr","fwk","PLK","uThu","oGqTs","jVK","DpmeH","ggA","HKsc","cYSr","DWzy","yUl","pUml","vTt","pHYrF","sUNq","ZtFvj","uDIM","cAr","wXrMI","oxEg","gfaN","oWJjf","FCc","yBnU",
                "sIe","Gqebw","OUs","EhGPM","qcO","AoKt","gSt","HpB","mb","viF","mEt","hTn","jrM","aJI","okSJ","KXu","jNmA","gD","isE","aFvvo","cZjj","qck","lqpEi","Fpfkm","edW","cvF","QUp","gqM","NDkf","KYZV","WQx","DqmzQ","Mzysg","Sq","deS","Su","Lbtas","WQn","Si","rMqpL","fnH","Sb","Sa","cwGH","Se","Sd","iOcY","Hpk","kPSUx","bhI","ZdY","ADPn","jdk","vq","AyTB","hGEFf","hhUOO","Ej","JuwJ","iMzjN","vITGC","OayVi","toJsk","SH","WQJ","v","SC","SB","SA","HxXP","PPyr","LTm","IBQ","pbdS","FQI","jbNUS","dlkij","aFcl","WcCH","lfgW","eDvy","fQIMV","innyq","wkQMe","YJRo","wfJON","kIBP","kBLbU","KqLu","haRVr","LVRNs","ZfvNM","vQPd","eSJY","iBAS","YrxW","zLeVe","fgvm","aLmK","AVFcl","hGUhG","KDMsI","zNU","hSiu","gCnX","YZAjH","dQmY","jBOj","jRA","mMBNu","BlCnN","fq","fs","ft","fv","JCwc","fx","fy","Ez","NhTrG","QbDn","yxj","fa","fb","hfJ","JjK","RUrFU","ff","fi","fl","JjB","TTrUz","fo","a","LJwNL","rbaW","WCw","vZiV","fX","sAPe","AkQ","nFJ","DHqdA","bRcw","jsEq","DVXeD","Nhp","fJ","aty","TaA","Qka","OKVOn","vYY","bjcj","KDP","ulWNb","uvu","RHL","XPUC","dXN","lshfE","ViF","ZNY","zcHf","mWgMC","JFk","Zpdn","AjCbx","AOC","wNVG","oZCVo","vQ","AjNr","zryI","JFg","Vowy","MIg","KLJTN","nVZwc","SCtnV","WTWWB","gZy","NrqMO","kSNbb","sMwKG","GLlgM","Ltgbp","yh","URG","yl","OqQ","yn","ya","yc","yb","mCes","L","Xhm","Mshw","wkQ","OqE","lrB","NyLxd","lwNru","mwXJ","vZnr","rwx","ocUXS","ys","ZPFL","yt","CRxa","yI","ATws","PYZ","yJ","yL","yMqDw","jvnO","KfwI","SFR","WoDaE","SzAfP","qeVcH","voyEi","BaD","yZ","BaC","GkSH","rwX","va","qkNxa","yR","PHSI","QGWX","yW","yV","JsTDb","LmXH","VZoXE","iQSK","vLGBe","GBfP","xuP","TPTm","qMHh","jWf","Omf","pSuBO","YXggn","KbO","VoNqh","pGAx","PqlAK","gfH","MjmvN","YYsEB","QKyB","lbRS","zPjK","IS","EM","EL","EO","YLmo","rvpp","suE","EJ","EE","ED","UNzbD","zjD","EA","EC","EB","ltELL","Fnf","HTIwv","dfn","mLVt","EZ","EU","KnJU","EV","EP","JFTqt","Edzj","sKmE","Ei","Eh","EgRx","IH","KuQIF","Eg","lyIU","cOZon","gTP","WFzUR","Pkf","NubG","w","ZegXL","Et","UhZZj","jIZ","hYhSn","Es","kexx","qCs","CbScQ","IO","YNMuy","LUX","oBOXS","Egtk","CUKVh","fJTDX","vCLGK","lyUt","hjrQE","xlYmh","dsBu","zi","JfVoZ","koh","VJy","YHi","LUt","XfRvf","UHvUg","olXLU","sFv","hBWfK","RJb","YXOnf","ZPmQt","FMwrO","juUi","jea","NyGlu","vM","MBDBv","IF","ziuY","gjBKy","TXNW","dKAX","gmwqc","zg","XN","XO","XM","TDpWT","dKAR","XA","qlr","XG","mmms","uRk","eUtZ","UFwYs","LbKy","ZIbu","pAca","KeEBW","XP","BEwr","npHh","Xj","Xk","tigFC","Xi","Xm","Xa","XftCB","HVD","Xd","WfE","Xz","hnj","AVNe",
                "Xy","gpr","mhmR","GwL","Xr","aISAn","Xq","SzXYG","blzqo","GIbh","RlX","kSq","LNVky","yxocY","HPoDo","UNQId","TDY","QjF","cmve","nGu","PikVs","SDZ","HriVE","PVgaH","dKmT","bhs","aXi","zv","uYCpR","nbeV","vxTj","aFP","KeEz","YkFAV","Nb","Qjc","bic","VnUZ","xdGB","FCTQa","RHXaU","ZSc","OUQW","vEO","Wxru","aXM","XSQE","kA","exE","kG","kF","Fgax","BQUN","qrk","tpN","kI","M","wDEmU","KwQ","jzFK","LmVgW","kP","iSlb","kV","EJZ","bmMmG","rjRn","ZwLVu","YUvZ","hkAI","kg","kd","jrLL","ypEdq","WOms","kl","ks","kr","OTZ","FGkjt","wmbSF","kv","exq","rhC","kx","EJp","ttWtD","aouI","GSNFL","weC","zG","DZE","RX","SsMQ","AtIx","JP","OpY","JR","ulMiW","ojf","ajys","gTrTb","PZi","XS","JD","mAvq","JF","JG","uEjhT","ctax","DlmMd","lbLzg","EqZ","Jz","YV","Ju","sspD","XiK","Jp","Jq","bwxnw","UFBP","EVtPr","Gyv","Gyu","Jo","WNKN","XT","iYYFB","DZv","Jd","zWsu","rflM","PWBg","lFxA","fSaiH","rFIm","QWJ","IAH","Bpg","zrewZ","lMjYQ","UAPpM","srtU","WHedl","MTJm","ShMxR","b","rNdZ","WQFa","hig","NYNY","flnnJ","KQWij","ZPfkE","UHA","YwW","pLG","dqOaz","ETezQ","crz","hiY","qVNkV","maqa","eTtc","aghUS","BpP","oxn","JFsXQ","xTIK","x","pJrJ","xfeT","BQ","gWd","gGVAD","pKq","SAYR","uRDlL","cHEHl","uRH","YDy","sMcD","Xg","woM","mWOj","FrVH","pXjE","cfhS","MWtq","lGP","OznY","Agj","Smac","rtmG","qfUBu","tvkDR","gQzDf","plOCO","Bgkj","ruQeO","FjmC","qjNX","gWS","JUZ","YkZ","qUZfD","PXiJ","NZZhf","WkugH","gEW","cFutT","HJwrP","PYycm","YcR","wBBC","VJwoq","uVvR","LRwsB","xDkG","byoUZ","bjXg","ZuE","Mj","qTJ","KJx","lBvv","mhpR","c","gUZQ","lIBO","Wjh","ttrr","HM","HCIwj","zxJBd","ikC","EqJG","keSL","IBWbP","DDc","Bn","uYA","EXnE","YlpaN","pP","rdAj","pV","pT","Ztj","pZ","UJFE","TTmaP","poa","pC","OLh","pF","tBDp","zGLYi","YDhQ","uQr","pO","GyC","ps","pp","pq","swo","swn","px","rWHN","zdPQY","MTgP","tmQDl","pb","ivEP","Bw","pf","QET","KYLmp","pk","pn","po","pm","PDZup","TWym","BJb","sucW","TEkO","N","YYe","NDX","Uskb","WHQp","dzIp","ULsVe","dh","XrHbh","yTa","EIAna","HToF","jx","uIqa","TOUMo","uFt","rASl","tip","ZJXSf","wSvW","oISh","YYF","BJS","ML","vCUr","ydjMw","nBxGV","pwQHk","TxjH","aeKh","vof","hVM","Qac","yHm","dIBJ","ewA","nHNK","ZbJ","nVY","Iri","GfR","KvU","reYJN","ZbQ","tqS","BpfQ","bBT","ewk","wZsO","kXS","FCYnD","bCsx","yVRB","cCW","LeWPj","Kvh","FAU","iyYi","UfYx","ngEq","FAN","XvL","nVa","vVV","UOKg","IUcVX","qeJG","IrE","qPlnx","LWLD","iqYP","Upe","QIrJR","LVm","bMD","SQw","dEZm","YOD","NhP","ydV","FDBV","qKHrF","Ilq","gsI","gbY","ygH","bMY","cQw","ZXIx","zPg","Hsfn","JjMrf","pcWO",
                "pZy","YOh","McdQU","ancVY","ErFy","NQzuD","tZtoq","nM","Bf","lxC","vyg","vbRtJ","bhfW","pDPBo","syY","iVbP","bIZqd","T","FVJre","oVTJ","hOYr","FFIHC","SRyxc","FQ","YFhZj","FamCj","SXcEL","yAYs","Uwon","NyNTG","jnq","dVtI","XBVCz","xEFen","sMrqN","LjfcK","TAfh","YvV","iVb","aCWPw","EtAth","inJj","Qibt","BrgVE","ZQbO","FY","Lry","uVgI","Eskst","dybo","IzU","Sail","IKuiH","Jhg","Oh","Of","BOet","Jxng","Ob","Oa","BufI","VmqW","NhsGn","Ekgs","QTfD","Ov","Ou","Ot","Os","bip","iely","uixBA","lZA","OL","d","OI","Qij","Rfly","OE","OD","tCr","OB","OA","BNsj","MLeYh","ilpo","qhuuJ","skquN","yEnrK","OU","OT","OR","OQ","WbQW","hvmQ","FgJy","VvZ","Ukh","VvS","qEKkX","gzEl","SmGd","Xuw","oGBD","ijf","lNGW","AMs","JDV","DImSF","ZLcvs","BWRyP","aHC","uPVDj","Xjx","FK","nsSj","dZG","TsDiZ","huEGL","OhDb","Fkc","WsS","fGytx","NVf","HXJ","tZTm","NWH","scX","be","bf","bIXlJ","MNbP","Xjb","QogQ","Tmjx","AeC","bj","bk","bt","Xjt","tzmJ","taE","ATDEB","idI","wget","WKf","otxFe","bD","kS","kKeGE","Llx","idz","bA","bB","aXuY","bM","bN","bO","znhmV","ScZ","bW","BPUDr","Fy","LkPgd","oeB","nJx","FmT","bZ","KDrd","Sybc","oRfiO","xqQvn","kU","Fgeq","lldW","qkWq","OoO","hiRk","czxFH","jjCv","Inzx","CbmT","UtxoG","QSz","PZeFE","zoB","msiIh","Qk","Inzu","uakp","ECY","sxAj","GqvFy","ixm","UdLez","BCi","Fb","asSC","bncD","pabd","LAWZ","xps","eZg","Bi","XNo","VeC","GDq","tOEr","GDs","oVZQQ","wxNI","eWcD","rBegH","uW","uV","YMmXs","uR","uM","uL","uN","ywWtf","vzjqY","uE","Yjy","uG","uF","WmcI","otKxS","SJx","Fk","Fif","wnG","sDE","ut","uv","uq","up","nYnn","um","ZePev","uo","zaEgk","AFeN","Pma","HygeI","ue","jGQ","HcsqZ","z","fdC","ub","fPTS","QZ","Tx","UbYIk","DmcL","PPYrb","bGTj","Tr","Tp","SnT","bJS","sul","Th","pVOJ","Td","rpKt","VHA","oPOV","Rlqg","DzWKX","cafZ","TX","GxdXq","TT","UKQTw","TS","gJySv","McLzv","Snv","Bslru","PFkl","TK","TI","GHQb","TD","tYLv","TB","QE","hjpKq","WEZH","OUjA","QDb","uKtpx","Lqjsi","QF","xbQ","AL","AO","AN","xbM","AP","HXPQt","JqBvG","caU","ZTpEb","AV","AY","cVoi","HHl","ZuR","mdFwJ","eHT","e","pIn","Af","ytUt","pIa","wcUHy","GNrA","Al","Ao","Uzc","Aq","xbl","MUP","Au","At","Aw","qyuL","Ay","LhRKG","DqRP","oKVT","tiF","NG","gs","jIIbr","ocH","kTXy","ogkDg","OWmd","VRv","gx","NowI","iGUvn","gb","ga","CNWL","gn","gm","gk","gj","gV","gU","Qhq","gQ","mzuKC","pnMZd","NbtSg","SU","gY","cBr","gF","zdbC","gB","gA","gO","gN","gM","gK","ZQc","gI","gH","dyVh","URlTx","GoZpJ","Zecg","TGTTe","bxmEm","hWG","iGx","P","kBQlJ","we","UJscf","NTMy","zwet","AyvvZ","evd","uheBs",
                "pZioN","Dxh","trq","Tedp","iGI","zl","zm","KnTL","zh","Blx","zk","zd","lWs","Blv","Blq","uGXy","zRyr","yYnm","KMyb","rdfkf","cfz","zy","zz","JE","JGduu","zu","IlYj","CYH","aLS","mOxz","KQXew","zM","NMmWz","WrnA","paOUc","zK","zD","Orw","MqUk","UOx","EnjCa","SDpc","BTXAJ","zC","odJ","DJrW","hoLk","zTQ","QIDL","oF","zU","zV","VhSEx","vSTPv","Lp","FTR","gcsot","MvkJ","QNHrE","gUOR","Jwq","mKpr","kHiOE","ZDg","xXLB","HaK","cerR","lZJc","ctL","MWjgG","jOxN","JYpe","ugeaI","dCfyH","zMN","wEiw","Xyy","fA","Bzc","IGx","aNnN","JwK","SBL","HQkzL","ohDP","IGn","pGtj","PeMG","FArd","FR","pSWu","FV","QN","FX","HaD","Crq","pPOqF","bfMo","Tqry","Vey","bIV","chS","FvWa","FE","FF","FG","JuVSa","BZM","Js","bghoS","ftXfp","Fp","JBtE","TxQbx","Fs","VeR","WgFb","UkW","OhQB","ducV","TcqG","eOENJ","TfSHj","mCiiy","Fa","fHPSL","kuih","Fd","Fe","Ff","Fg","BZo","Gys","TwQnD","fYVaV","drIz","aA","vLIJ","dbGO","xTyqM","jhlvz","RA","azxR","Oxis","uEoZ","zpLQE","JLlS","opoV","iin","SfN","DvlTP","NzStv","RulTQ","ZTi","f","qZp","qlhR","uITj","qZv","Ja","XHP","mXAs","BZxi","wpMZY","Aolh","KqbI","mTP","RNMk","dn","YK","LjqV","SJWMH","dwD","xqby","FcW","UQ","YE","LQrN","YF","jRW","YQ","FcB","TSe","Wcg","BlUnQ","ZHQZd","KFo","YR","YW","Ywr","vIa","Ym","eeuC","SZdPF","Yn","Ya","hFR","Ye","TE","Yg","Yf","PLw","Yx","apZeq","Yz","Yp","Yr","XqAUF","jRz","JZzX","mgeDf","ABC","wriD","ABE","zHNZ","rxWpx","uJunb","HSIvc","kxAAu","ecvvK","Q","DRfh","sgKs","jfC","srx","hEvX","gDrIZ","NZp","kaDl","LzLFU","vyuGl","BDy","pdvqC","PbwLD","PZOpQ","SkxG","Ewwh","EciZa","FHCUf","BCnP","TIyFM","usSJ","hCNDQ","AhAE","gOYkm","nkhDA","lB","zfz","tsF","lO","lL","EfpiJ","vma","lT","kby","lQ","ttC","Nl","qF","iFo","lZ","WRXN","byA","bMhXi","Kxj","Dzue","SGDLB","udhi","ZrF","lm","eua","QmKj","lw","eeuGe","lu","hHg","itiTS","Zhdg","KoE","tJDwR","WcJzJ","VqgE","TyheH","lx","vmQ","zgFP","zevE","BFF","bZHv","Hshx","HRGzk","fiFK","xKGt","dak","NpbQ","YuGzv","Nf","qH","ykQN","DtGXa","ujMBD","nfY","gnutR","Sak","tIl","Pra","earEG","vzQFK","ngXr","zaKxu","Yt","ChFNW","yFI","tNxld","QEDVZ","OMlfu","RCsi","xgDqK","lzE","kRcwS","Jts","gBAVT","AGZSu","AoC","RgBR","aZCUD","xLdPT","tIk","djd","fFQ","Xgxvq","TuH","AoV","asf","PKa","VdT","IFM","LAjd","ssay","Vbe","aUDAm","IDB","YtU","YtR","ouY","oker","iLuvc","wFSPG","mDWj","Nw","swp","bTia","saVBR","OuC","voHE","guVC","DsOWA","XInJ","KDviT","NJ","bOUC","UyUN","NUGR","pZzT","SDLNk","WNKFy","brYjt","GwBp","NL","zBQZp","RPRPo","gfCJ","lRNp","RmZG","hZA","NN","g","gZEAP","Kcnrw","WOp",
                "Vllvy","IPGl","KjQ","GhN","cMXwx","bwkYI","LXITl","ZDQl","aCUQ","BmN","VEgP","UKFg","sC","AER","EfEg","ivEQz","aZG","Cdqy","JhpR","JBs","ogrIg","Qse","DGJ","QTtm","lGM","GNTvC","sF","cbCS","Xnrw","TCw","kZoBU","mvYYj","Tmzjm","MUi","aAX","dTU","GrzV","EieKn","UKVX","GLKG","oQvNy","Kf","qlYn","eZeKg","Kk","yXnh","qKA","Kh","reoD","LfIjN","Kl","lPn","R","Kw","Kv","qKS","Kz","aHqN","Kx","KC","Ax","Xt","KD","AZrS","KI","KO","CIiR","KM","KPusv","rWIzX","sTltH","KP","KW","CeFst","KU","KT","zxOW","KX","FNj","IZ","ctJP","bZs","POBnL","oCa","sw","adZc","xrF","HqHza","WGJ","UpJ","cbueX","XADrP","XYH","OtQV","UKHvF","BIp","cKnlF","GspGf","YeSTh","aUlvs","HxG","tLHrm","EjK","VlsG","WOnHd","BYYy","WGU","mmnEw","bIT","zktxh","nqJ","kMYH","CgqK","AAz","QxYQW","zZT","cKz","STr","cfeT","hv","odsV","xnGnA","GXyOv","AMMa","iqxd","CQlb","zVUDJ","KRqZt","zTVH","WcQw","QQcwG","KXsTp","eQmCz","nW","UmS","QsqHr","YPn","WaEU","zfw","rSlQo","UjN","GFI","YLaf","IDeZ","BTQu","YLW","iGlpo","QiOsV","DaADV","HXrT","ozDRQ","MoR","sTGpC","IJkLK","iQku","Iab","tdhW","Po","KuMlm","FOfFc","DJvXA","Fvv","UQazh","NHaN","CbYNt","cvJxV","eQNj","IqAwq","oYWn","qVAS","WOgyC","cRC","JDEW","Moo","fnooA","MgJ","szR","JdJw","vjfB","dbW","ivBj","qS","qR","qU","qW","LPykh","VXE","hoI","eFs","hGp","Ry","qA","QJz","Rkuq","Bpwm","TVjo","uNh","eFa","tyVu","kbe","qM","RnPWF","GaDXj","qq","qp","qs","qr","gbb","XbpdJ","eATun","qv","qy","h","GRhY","dpy","KIT","HjFta","qc","meAVC","ymI","qf","veEL","onx","ql","qo","yxXeh","qtv","fVQ","Pp","Pq","nFCXF","Pt","Pu","Pz","FEj","dPoiz","WNo","ViOrC","moqr","Pc","CRF","Pd","Pj","wM","Xahg","Pi","drJjW","tsT","Pm","PR","JgI","YpMSR","XgpeP","PV","mrtC","PT","PU","SMMnU","usRj","cTuqR","ZoO","PB","AVA","fgLeE","PD","GkN","PJ","EHEN","Rk","DdG","YKjA","PL","PM","NgD","YmnRS","xWuj","mDxyr","RV","S","RW","RLS","lCEb","NpQN","tHrVh","wapj","xusya","iZyV","MDzU","lRQdL","vCQMK","ww","xyOR","etq","IMUUd","nUt","Gri","FGted","rIvvN","ejdMQ","hIc","Xmia","GzK","iEN","rXDLt","WcmTg","jYqwK","GAlI","kfPT","todZB","cj","ci","ch","SGKS","CpjQ","vCHnf","tNPQm","GuzJA","lj","lPuzm","cg","vqpP","Sjwyl","cz","LwIPQ","UMM","EWzK","UMO","ttT","cw","cv","yaC","ct","cI","cH","cN","yOnd","tfKL","mEMd","cB","eZmwL","Gcf","qYbNE","cD","VwBc","wCsKU","yhYF","RG","gxXM","Njgx","cS","XmW","cV","IR","cT","rCq","RYy","NNOMj","zSgs","FjoX","vjWuG","MDylZ","YBdt","LBI","fGO","YiWz","cvK","OxVkc","XhER","TdTZw","qKzBu","XWQ","IajV","ajoG","khxVy","RO","uDWP","kavc","zKJ","hmV","Anh","qLGw","iBrvB",
                "aoif","kPdMn","XZS","PlZY","ly","rbc","Optlw","SBCjN","mBox","rLReW","vb","XFx","rgFlx","aw","vf","vg","IYM","cdmjP","vj","av","vl","vm","vn","vp","SOp","vr","CmtO","sYnJQ","vu","cAkk","DiDsD","vx","tcFHt","jxaC","mVu","dfjAp","vC","IqhDs","PTCl","pOyZO","YJrTz","vK","vL","XEMH","EnrY","Hwa","nDjQF","qSNui","vR","flRcG","sxHr","vV","SOYB","vX","AGxln","FLAVZ","bcCxI","PCUuC","kSMU","nbaD","pGPpl","skzE","nsrI","QrH","Gwo","ZYCms","YhAl","qTn","xAj","gAL","fQtE","dyGjT","tSLdH","aE","pht","PMeAB","kdEa","Qnyk","i","xAQ","SLwV","oopm","zyj","ioP","RxX","Bju","lPGDi","xAM","nfnL","eNRn","xAB","ofy","KzXu","RidQ","Zpy","BF","yffh","Vo","kgd","BC","bcld","BO","BH","BJ","BK","ZrbV","BU","tcl","RgdCD","BP","UwN","Wmm","EYWSY","VYK","VYH","Lac","NNs","BY","BZ","oVbB","Bd","Be","tLbjs","RYYDN","Ba","LSkR","Mpa","pgcZu","oTjWp","DcFO","Bo","pgf","Bj","Bk","TQoL","ZvJQ","TIh","bfAr","GEIY","gpYhC","MoaRT","UsZ","iWjsQ","Wqem","mK","jxwo","ixef","cKCg","PPNn","IUBv","NXZ","EwSQT","KEeK","RvV","QnEd","kMZIK","lxszP","Hyz","GNsm","gRhyR","rpW","HyJ","EiZ","vOWY","QNwy","dGr","izZFP","Ugew","xMhf","YWca","cxW","esU","WRnn","bGd","hJS","bVGXK","Npni","pJ","iLPAD","JduME","Lk","Yxakm","Suz","JNp","ADbKP","bubMq","yLR","qeD","aqra","zkfM","snvfw","CdiTo","uQJ","tmc","uLTXl","WqAf","jlB","yuUJJ","OJik","ZCn","iDA","Ux","Uz","Uu","hnM","Uw","Uq","Up","Um","Uo","biN","upan","FOAdb","Acum","Uj","Ue","RIuC","Uf","ScQ","pqGu","Ub","zJOM","PkIo","bIj","VF","Ptg","sFwYY","dMDvf","Wne","LRM","US","kzQll","UM","UL","ZyIDw","UN","UI","UH","kchf","UD","UA","dcS","WWVZ","uggnM","kwJ","QqV","oggoa","bubre","rlMf","WrzLm","gHdm","ZZn","uRYPn","kVP","OgemF","MOHP","DYfwk","zHm","aSMOP","yMxDQ","lDwq","nwkq","MyZGr","BDHa","WdYO","fDF","merQ","Nfnp","cOIr","CGD","rcr","CGY","tIO","IUU","rIBn","safxK","SPgi","rBc","diLR","jlhb","GMuwx","kEENE","aDoK","hx","ZwYY","pd","tiVu","KKkKU","hq","Lu","wxpfr","hu","hj","Zlt","hh","pFDE","sOU","MyZJ","QmO","hm","ylFe","hc","Rt","hf","Cqpkq","vJDn","he","hZ","TSKw","FEd","TIqQ","eMjE","JJq","JQvMn","mKAB","j","idNQ","hW","SwR","hU","hJ","hH","GjM","hN","SyZVs","hL","rZgz","hA","UFbtu","IEmdy","myQF","mgYSh","aIuc","msjg","FHPDW","ez","LgsTg","MSR","Gvd","bPxCz","teTj","YxL","bdm","ctJZB","unNN","kgqGp","GvJ","VoqD","eURS","FDmm","YRN","GvL","OogV","CL","nnhZU","RTx","MFMrX","cOZD","Jdff","USc","DKhN","YFiyI","RZkH","lzBzq","GZidL","bcI","hAukP","aVYQ","Pfco","KuLSF","GnyPV","JrK","GcC","RkD","eoQ","U","nMtIu","bTHPK","rvwZ","FJ","gap","XwkWf","lGIO",
                "HfY","tLzTy","LElO","bpBFF","UuO","nwyD","MHiC","pIfrv","rGZm","IRJY","vqsg","yVzS","AYEW","qqaB","yvkD","xfQCj","tWRoQ","qRqKF","XPyj","Lssr","bOWU"};

        findSubStrings.findSubstrings(words, parts);

    }

    String[] findSubstrings(String[] words, String[] parts) {

        if (parts == null || parts.length == 0){
            return words;
        }

        Trie trie = new Trie();

        for (String part :  parts){
            trie.addWord(part);
        }

        for (int i = 0; i < words.length; i++) {
            words[i] = trie.findBiggestSubstring(words[i]);
        }

        for (String word : words){
            System.out.println(word);
        }

        return words;

    }
}

class Trie{
    private Node rootNode = new Node();
    public void addWord(String word){
        addWordRecursive(word, 0, rootNode);
    }

    private void addWordRecursive(String word, int index, Node currentNode) {
        if (index == word.length()){
            currentNode.isCompleteWord = true;
            return;
        }
        char c = word.charAt(index);
        Node n = currentNode.children.get(c);
        if (n == null){
            n = new Node();
            currentNode.children.put(c, n);
        }
        index++;
        addWordRecursive(word, index, n);
    }

    public String findBiggestSubstring(String word) {
        return createSubstring(word, rootNode);
    }

    private String createSubstring(String word, Node node) {

        Node currentNode = node;
        int minIndex = -1;
        int matchedIndex = 0;
        int maxLength = 0;
        int length = 0;
        boolean found = false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            Map<Character, Node> partMap = currentNode.children;

            if (partMap != null && partMap.size() > 0){
                if (partMap.containsKey(c)) {
                    if (!found) {
                        found = true;
                        matchedIndex = i;
                    }
                    if (currentNode.isCompleteWord) {
                        length = i - matchedIndex;
                        if (maxLength < length) {
                            minIndex = matchedIndex;
                            maxLength = length;
                        }
                    }
                    currentNode = partMap.get(c);
                } else {
                    //It matched till previous
                    if (found){
                        if (currentNode.isCompleteWord) {
                            length = i - matchedIndex;
                            if (maxLength < length) {
                                minIndex = matchedIndex;
                                maxLength = length;
                            }
                            found = false;
                            currentNode = node;
                            i = matchedIndex;
                        } else {
                            found = false;
                            currentNode = node;
                            i = matchedIndex;
                        }
                    }
                }

                if (i == word.length()-1){
                    if (!currentNode.isCompleteWord && found){
                        i = matchedIndex;
                        found = false;
                        currentNode = node;
                    }
                }

            } else {
                //It matched till previous
                if (found){
                    if (currentNode.isCompleteWord) {
                        length = i - matchedIndex;
                        if (maxLength < length) {
                            minIndex = matchedIndex;
                            maxLength = length;
                        }
                        found = false;
                        currentNode = node;
                        i = matchedIndex;
                    } else {
                        found = false;
                        currentNode = node;
                        i = matchedIndex;
                    }
                }

            }
        }

        if (found && currentNode != null && currentNode.isCompleteWord){
            length = word.length() - matchedIndex;
            if (maxLength < length){
                minIndex = matchedIndex;
                maxLength = length;
            }
        }

        if (maxLength > 0){
            return getModifiedString(word, minIndex, maxLength);
        }


        return word;
    }

    private String getModifiedString(String word, int matchedIndex, int matchedLength) {
        int endIndex = matchedIndex + matchedLength+1;
        StringBuffer modifiedString = new StringBuffer(word);
        modifiedString.insert(matchedIndex, '[');
        modifiedString.insert(endIndex, ']');
        return modifiedString.toString();
    }
}

class Node{
    public Map<Character, Node> children;
    public boolean isCompleteWord;

    public Node() {
        children = new HashMap<>();
        isCompleteWord = false;

        Set<Character> characters = children.keySet();

        characters.iterator();
    }

}
